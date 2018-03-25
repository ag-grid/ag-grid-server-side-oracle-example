package com.ag.grid.enterprise.oracle.demo.request;

import com.ag.grid.enterprise.oracle.demo.filter.ColumnFilter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

public class EnterpriseGetRowsRequest implements Serializable {

    private int startRow, endRow;

    // row group columns
    private List<ColumnVO> rowGroupCols;

    // value columns
    private List<ColumnVO> valueCols;

    // pivot columns
    private List<ColumnVO> pivotCols;

    // true if pivot mode is one, otherwise false
    private boolean pivotMode;

    // what groups the user is viewing
    private List<String> groupKeys;

    // if filtering, what the filter model is
    private Map<String, ColumnFilter> filterModel;

    // if sorting, what the sort model is
    private List<SortModel> sortModel;

    public EnterpriseGetRowsRequest() {
        this.rowGroupCols = emptyList();
        this.valueCols = emptyList();
        this.pivotCols = emptyList();
        this.groupKeys = emptyList();
        this.filterModel = emptyMap();
        this.sortModel = emptyList();
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public List<ColumnVO> getRowGroupCols() {
        return rowGroupCols;
    }

    public void setRowGroupCols(List<ColumnVO> rowGroupCols) {
        this.rowGroupCols = rowGroupCols;
    }

    public List<ColumnVO> getValueCols() {
        return valueCols;
    }

    public void setValueCols(List<ColumnVO> valueCols) {
        this.valueCols = valueCols;
    }

    public List<ColumnVO> getPivotCols() {
        return pivotCols;
    }

    public void setPivotCols(List<ColumnVO> pivotCols) {
        this.pivotCols = pivotCols;
    }

    public boolean isPivotMode() {
        return pivotMode;
    }

    public void setPivotMode(boolean pivotMode) {
        this.pivotMode = pivotMode;
    }

    public List<String> getGroupKeys() {
        return groupKeys;
    }

    public void setGroupKeys(List<String> groupKeys) {
        this.groupKeys = groupKeys;
    }

    public Map<String, ColumnFilter> getFilterModel() {
        return filterModel;
    }

    public void setFilterModel(Map<String, ColumnFilter> filterModel) {
        this.filterModel = filterModel;
    }

    public List<SortModel> getSortModel() {
        return sortModel;
    }

    public void setSortModel(List<SortModel> sortModel) {
        this.sortModel = sortModel;
    }
}