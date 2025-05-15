package com.petmart.petmart.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    @Column(name="category_name")
    private int category_name;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getCategory_name() {
        return category_name;
    }

    public void setCategory_name(int category_name) {
        this.category_name = category_name;
    }
}
