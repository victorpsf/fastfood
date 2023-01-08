package com.api.fastfood.dtos.Classifications;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateClassificationDto {
    @NotBlank
    @Size(max = 255)
    private String name;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}

