package com.api.fastfood.dtos.Products;

import jakarta.validation.constraints.NotNull;

public class ChangeProductDto extends CreateProductDto {
    @NotNull
    private Integer id;

    public Integer getId() { return this.id; }
    public ChangeProductDto setId(Integer id) {
        this.id = id;
        return this;
    }
}
