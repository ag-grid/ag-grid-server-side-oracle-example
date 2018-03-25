package com.ag.grid.enterprise.sql.demo.filter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "filterType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NumberColumnFilter.class, name = "number"),
        @JsonSubTypes.Type(value = SetColumnFilter.class, name = "set") })
public abstract class ColumnFilter {
    public String filterType;
}