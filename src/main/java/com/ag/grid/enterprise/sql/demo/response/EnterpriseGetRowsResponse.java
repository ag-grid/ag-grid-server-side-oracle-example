package com.ag.grid.enterprise.sql.demo.response;

import java.util.List;
import java.util.Map;

public class EnterpriseGetRowsResponse {
    private List<Map<String, Object>> data;
    private int lastRow;
    private List<String> secondaryColumns;

    public EnterpriseGetRowsResponse() { }

    public EnterpriseGetRowsResponse(List<Map<String, Object>> data, int lastRow, List<String> secondaryColumns) {
        this.data = data;
        this.lastRow = lastRow;
        this.secondaryColumns = secondaryColumns;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public List<String> getSecondaryColumns() {
        return secondaryColumns;
    }

    public void setSecondaryColumns(List<String> secondaryColumns) {
        this.secondaryColumns = secondaryColumns;
    }
}