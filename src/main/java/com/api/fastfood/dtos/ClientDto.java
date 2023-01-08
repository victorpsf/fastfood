package com.api.fastfood.dtos;

import com.api.fastfood.Enums.DocumentType;
import com.api.fastfood.Validators.EnumNamePatternConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientDto {
    @NotBlank
    private String name;

    @Size(max = 50)
    private String document;

    @EnumNamePatternConstraint(regexp = "CPF|RG|CNPJ")
    private DocumentType doctype;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public DocumentType getDoctype() {
        return this.doctype;
    }

    public void setDoctype(DocumentType doctype) {
        this.doctype = doctype;
    }
}
