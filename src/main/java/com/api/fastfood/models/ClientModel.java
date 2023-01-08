package com.api.fastfood.models;

import com.api.fastfood.Enums.DocumentType;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Client")
public class ClientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255)
    private String name;

    @Column(nullable = false, unique = false, length = 50)
    private String document;

    @Column(nullable = false, unique = false, length = 3)
    private DocumentType doctype = DocumentType.None;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.document = document.replaceAll("[^0-9]", "");
    }

    public DocumentType getDoctype() {

        return this.doctype;
    }

    public void setDoctype(DocumentType doctype) {
        this.doctype = doctype;
    }
}
