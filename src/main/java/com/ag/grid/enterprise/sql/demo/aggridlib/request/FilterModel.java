package com.ag.grid.enterprise.sql.demo.aggridlib.request;

import java.util.List;
import java.util.Objects;

public class FilterModel {
    private String type;
    private String filter;
    private String filterTo;
    private String filterType;
    private List<String> values;

    public FilterModel() {}

    public FilterModel(String type, String filter, String filterTo, String filterType, List<String> values) {
        this.type = type;
        this.filter = filter;
        this.filterTo = filterTo;
        this.filterType = filterType;
        this.values = values;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilterTo() {
        return filterTo;
    }

    public void setFilterTo(String filterTo) {
        this.filterTo = filterTo;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterModel model = (FilterModel) o;
        return Objects.equals(type, model.type) &&
                Objects.equals(filter, model.filter) &&
                Objects.equals(filterTo, model.filterTo) &&
                Objects.equals(filterType, model.filterType) &&
                Objects.equals(values, model.values);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, filter, filterTo, filterType, values);
    }

    @Override
    public String toString() {
        return "FilterModel{" +
                "type='" + type + '\'' +
                ", filter='" + filter + '\'' +
                ", filterTo='" + filterTo + '\'' +
                ", filterType='" + filterType + '\'' +
                ", values=" + values +
                '}';
    }
}