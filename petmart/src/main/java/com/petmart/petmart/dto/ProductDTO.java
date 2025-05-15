package com.petmart.petmart.dto;

import com.petmart.petmart.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDTO {
    private int id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private LocalDateTime time;

    public ProductDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getProductName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
