package com.api.fastfood.dtos.Products;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class GetProductDto {
    private Integer id;
    private String name;
    private ArrayList<Integer> classifications = new ArrayList<Integer>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getClassifications() {
        return classifications;
    }

    public void setClassifications(ArrayList<Integer> classifications) {
        this.classifications = classifications;
    }
}
