package com.api.fastfood.dtos.Products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateProductDto {
    @NotBlank
    @Size(max = 255)
    private String name;
    private Integer[] classifications;

    public Integer[] getClassifications() { return this.classifications; }
    public CreateProductDto setClassifications(Integer[] classifications) {
        this.classifications = classifications;
        return this;
    }
    public String getName() { return this.name; }
    public CreateProductDto setName(String name) {
        this.name = name;
        return this;
    }
}
