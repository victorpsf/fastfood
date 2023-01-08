package com.api.fastfood.dtos;

public class Pagination<T> {
    private Integer limit = 20;
    private Integer lastId = 0;
    private T model;

    public T getModel() {
        return this.model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public Integer getLastId () { return this.lastId; }
    public void setLastId(Integer lastId) { this.lastId = lastId; }
}
