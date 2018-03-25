package com.ag.grid.enterprise.sql.demo.dao;

import com.ag.grid.enterprise.sql.demo.builder.OracleSqlQueryBuilder;
import com.ag.grid.enterprise.sql.demo.request.ColumnVO;
import com.ag.grid.enterprise.sql.demo.request.EnterpriseGetRowsRequest;
import com.ag.grid.enterprise.sql.demo.response.EnterpriseGetRowsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.ag.grid.enterprise.sql.demo.builder.EnterpriseResponseBuilder.createResponse;
import static java.lang.String.format;
import static java.util.stream.Collectors.toMap;

@Repository("tradeDao")
public class TradeDao {

    private JdbcTemplate template;
    private OracleSqlQueryBuilder queryBuilder;

    @Autowired
    public TradeDao(JdbcTemplate template) {
        this.template = template;
        queryBuilder = new OracleSqlQueryBuilder();
    }

    public EnterpriseGetRowsResponse getData(EnterpriseGetRowsRequest request) {
        String tableName = "trade"; // could be supplied in request as a lookup key?

        Map<String, List<String>> pivotValues = getPivotValues(request);

        String sql = queryBuilder.createSql(request, tableName, pivotValues);

        List<Map<String, Object>> rows = template.queryForList(sql);

        return createResponse(request, rows, pivotValues);
    }

    private Map<String, List<String>> getPivotValues(EnterpriseGetRowsRequest request) {
        return request.getPivotCols().stream()
                .map(ColumnVO::getField)
                .collect(toMap(pivotCol -> pivotCol, this::getPivotValues));
    }

    private List<String> getPivotValues(String pivotColumn) {
        String sql = "SELECT DISTINCT %s FROM trade";
        return template.queryForList(format(sql, pivotColumn), String.class);
    }
}