package com.petmart.petmart.entity;

import jakarta.persistence.*;

@Entity(name ="user_detail")
public class UserDetail {

    @Column(name = "user_id")
    @Id
    private int id;

    @Column(name ="full_name")
    private String fullName;

    @Column(name ="email")
    private String email;

    @Column(name ="phone")
    private String phone;

    @Column(name ="status")
    private Boolean status;

    @OneToOne
    @MapsId
    @JoinColumn(name ="user_id")
    private Users users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
