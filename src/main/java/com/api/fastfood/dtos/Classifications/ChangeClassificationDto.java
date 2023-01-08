package com.api.fastfood.dtos.Classifications;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ChangeClassificationDto extends CreateClassificationDto {
    @NotNull
    private Integer id;

    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }
}
