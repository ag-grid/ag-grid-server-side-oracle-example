var columnDefs = [

  // these are the row groups, so they are all hidden (they are shown in the group column)
  {headerName: 'Hierarchy', children: [
      {headerName: 'Product', field: 'PRODUCT', type: 'dimension', rowGroupIndex: 0, hide: true},
      {headerName: 'Portfolio', field: 'PORTFOLIO', type: 'dimension', rowGroupIndex: 1, hide: true},
      {headerName: 'Book', field: 'BOOK', type: 'dimension', rowGroupIndex: 2, hide: true},
    ]},

  // some string values, that do not get aggregated
  {headerName: 'Attributes', children: [
    {headerName: 'Trade', field: 'TRADEID', width: 100, type: 'dimension',
      filter: "agNumberColumnFilter",
      filterParams: {
        applyButton: true,
        newRowsAction: 'keep'
      }
    },
    {
      headerName: 'Deal Type', field: 'DEALTYPE', type: 'dimension',
      filter: 'agSetColumnFilter',
      filterParams: {
        values: ['Financial', 'Physical'],
        newRowsAction: 'keep'
      }
    },
    {headerName: 'Bid', field: 'BIDTYPE', type: 'dimension', width: 100, filter: 'agSetColumnFilter',
      filterParams: {
        values: ['Buy', 'Sell'],
        newRowsAction: 'keep'
      }
    }
  ]},

  // all the other columns (visible and not grouped)
  {headerName: 'Values', children: [
    {headerName: 'Current', field: 'CURRENTVALUE', type: 'measure'},
      {headerName: 'Previous', field: 'PREVIOUSVALUE', type: 'measure'},
      {headerName: 'PL 1', field: 'PL1', type: 'measure'},
      {headerName: 'PL 2', field: 'PL2', type: 'measure'},
      {headerName: 'Gain-DX', field: 'GAINDX', type: 'measure'},
      {headerName: 'SX / PX', field: 'SXPX', type: 'measure'},
      {headerName: '99 Out', field: 'X99OUT', type: 'measure'}
  ]}
];

let gridOptions = {
  columnTypes: {
    dimension: {
      enableRowGroup: true,
      enablePivot: true,
    },
    measure: {
      width: 150,
      aggFunc: 'sum',
      enableValue: true,
      cellClass: 'number',
      valueFormatter: numberCellFormatter,
      cellRenderer:'agAnimateShowChangeCellRenderer',
      allowedAggFuncs: ['avg','sum','min','max'],
      cellClassRules: {'negative': 'x < 0'}
    }
  },
  autoGroupColumnDef: {
    headerName: 'Hierarchy',
    width: 250
  },
  enableSorting: true,
  enableFilter: true,
  columnDefs: columnDefs,
  enableColResize: true,
  rowModelType: 'enterprise',
  cacheBlockSize: 100,
  rowGroupPanelShow: 'always',
  pivotPanelShow: 'always',
  suppressAggFuncInHeader: true,
  animateRows: false
};

function EnterpriseDatasource() {}

EnterpriseDatasource.prototype.getRows = function (params) {
  let jsonRequest = JSON.stringify(params.request, null, 2);
  console.log(jsonRequest);

  let httpRequest = new XMLHttpRequest();
  httpRequest.open('POST', 'http://localhost:9090/getRows');
  httpRequest.setRequestHeader("Content-type", "application/json");
  httpRequest.send(jsonRequest);
  httpRequest.onreadystatechange = () => {
    if (httpRequest.readyState === 4 && httpRequest.status === 200) {
      let result = JSON.parse(httpRequest.responseText);
      params.successCallback(result.data, result.lastRow);

      updateSecondaryColumns(params.request, result);
    }
  };
};

// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
  let gridDiv = document.querySelector('#myGrid');
  new agGrid.Grid(gridDiv, gridOptions);
  gridOptions.api.setEnterpriseDatasource(new EnterpriseDatasource());
});

let updateSecondaryColumns = function (request, result) {
  let valueCols = request.valueCols;
  if (request.pivotMode && request.pivotCols.length > 0) {
    let secondaryColDefs = createSecondaryColumns(result.secondaryColumnFields, valueCols);
    gridOptions.columnApi.setSecondaryColumns(secondaryColDefs);
  } else {
    gridOptions.columnApi.setSecondaryColumns([]);
  }
};

let createSecondaryColumns = function (fields, valueCols) {
  let secondaryCols = [];

  function addColDef(colId, parts, res) {
    if (parts.length === 0) return [];

    let first = parts.shift();
    let existing = res.find(r => r.groupId === first);

    if (existing) {
      existing['children'] = addColDef(colId, parts, existing.children);
    } else {
      let colDef = {};
      let isGroup = parts.length > 0;
      if(isGroup) {
        colDef['groupId'] = first;
        colDef['headerName'] = first;
      } else {
        let valueCol = valueCols.find(r => r.field === first);

        colDef['colId'] = colId;
        colDef['headerName'] =  valueCol.displayName;
        colDef['field'] = colId;
        colDef['type'] = 'measure';
      }

      let children = addColDef(colId, parts, []);
      children.length > 0 ? colDef['children'] = children : null;

      res.push(colDef);
    }

    return res;
  }

  fields.sort();
  fields.forEach(field => addColDef(field, field.split('_'), secondaryCols));
  return secondaryCols;
};

function numberCellFormatter(params) {
  let formattedNumber = Math.floor(Math.abs(params.value)).toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
  return params.value < 0 ? '(' + formattedNumber + ')' : formattedNumber;
}