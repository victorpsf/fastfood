package com.api.fastfood.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "Classification")
public class ClassificationModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255)
    private String name;

    @ManyToMany(mappedBy = "classifications")
    @JsonIgnore
    private Collection<ProductModel> products;

    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public Collection<ProductModel> getProducts() { return this.products; }
    public void setProducts(Collection<ProductModel> products) { this.products = products; }
}
