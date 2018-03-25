package com.ag.grid.enterprise.oracle.demo.request;

import java.io.Serializable;
import java.util.Objects;

public class ColumnVO implements Serializable {
    private String id;
    private String displayName;
    private String field;
    private String aggFunc;

    public ColumnVO() {
    }

    public ColumnVO(String id, String displayName, String field, String aggFunc) {
        this.id = id;
        this.displayName = displayName;
        this.field = field;
        this.aggFunc = aggFunc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAggFunc() {
        return aggFunc;
    }

    public void setAggFunc(String aggFunc) {
        this.aggFunc = aggFunc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnVO columnVO = (ColumnVO) o;
        return Objects.equals(id, columnVO.id) &&
                Objects.equals(displayName, columnVO.displayName) &&
                Objects.equals(field, columnVO.field) &&
                Objects.equals(aggFunc, columnVO.aggFunc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName, field, aggFunc);
    }
}