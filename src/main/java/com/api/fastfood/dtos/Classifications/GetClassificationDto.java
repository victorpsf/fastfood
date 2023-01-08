package com.api.fastfood.dtos.Classifications;

public class GetClassificationDto {
    private Integer id;
    private String name;

    public GetClassificationDto() { }

    public GetClassificationDto(Integer id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}
