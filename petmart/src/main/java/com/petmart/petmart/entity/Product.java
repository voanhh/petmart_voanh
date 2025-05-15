package com.petmart.petmart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name="product")
public class Product {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name="product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="quantity")
    private int quantity;

    @Column(name="release_date")
    private Date release_date;

    @OneToOne(mappedBy = "product")
    @PrimaryKeyJoinColumn
    private ProductDetail productDetail;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}
