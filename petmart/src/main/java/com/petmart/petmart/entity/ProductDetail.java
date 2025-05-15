package com.petmart.petmart.entity;

import jakarta.persistence.*;

@Entity(name="product_detail")
public class ProductDetail {

    @Column(name="product_id")
    @Id
    private int productID;

    @Column(name="description")
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @OneToOne
    @MapsId
    @JoinColumn(name ="product_id")
    private Product product;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
