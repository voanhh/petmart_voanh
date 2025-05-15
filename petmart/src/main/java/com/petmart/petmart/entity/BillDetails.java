package com.petmart.petmart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name="bill_detail")
public class BillDetails {

    @EmbeddedId
    private BillDetailKey id;

    @ManyToOne
    @MapsId("billId")
    @JoinColumn(name="bill_id")
    private Bill bill;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private int quantity;

    @Column(name="unit_price")
    private BigDecimal unitPrice;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BillDetailKey getId() {
        return id;
    }

    public void setId(BillDetailKey id) {
        this.id = id;
    }
}
