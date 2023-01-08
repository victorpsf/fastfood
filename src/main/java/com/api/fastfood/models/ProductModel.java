package com.api.fastfood.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

@Entity
@Table(name = "Product")
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255)
    private String name;

    @ManyToMany
    @JoinTable(
            name="product_classification",
            joinColumns= {@JoinColumn(name="product_id")},
            inverseJoinColumns= {@JoinColumn(name="classification_id")}
    )
    private Collection<ClassificationModel> classifications = new ArrayList<ClassificationModel>();

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
    public Collection<ClassificationModel> getClassifications() {
        return this.classifications;
    }
    public void setClassifications(Collection<ClassificationModel> classifications) { this.classifications = classifications; }
}
