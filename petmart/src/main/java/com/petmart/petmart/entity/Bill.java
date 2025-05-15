package com.petmart.petmart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "bill")
public class Bill {
    @Id
    @Column(name="bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billIid;

    @Column(name="create_at")
    private Date createdAt;

    @Column(name="total_amount")
    private BigDecimal total_amount;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name="id")
    private Users users;

    @OneToMany(mappedBy = "bill",cascade = CascadeType.ALL)
    private List<BillDetails> billDetails;

    public int getBillIid() {
        return billIid;
    }

    public void setBillIid(int billIid) {
        this.billIid = billIid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<BillDetails> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetails> billDetails) {
        this.billDetails = billDetails;
    }
}
