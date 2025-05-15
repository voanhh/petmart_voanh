package com.petmart.petmart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillDetailKey implements Serializable {

    @Column(name = "bill_id")
    private int billId;

    @Column(name = "product_id")
    private int productId;

    // Constructors
    public BillDetailKey() {}

    public BillDetailKey(int billId, int productId) {
        this.billId = billId;
        this.productId = productId;
    }

    // Getters & setters

    // equals() và hashCode() rất quan trọng!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillDetailKey that)) return false;
        return billId == that.billId && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, productId);
    }
}

