package com.example.demoOnlineProductDeliveryManagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="table_user")
public class User implements Serializable {
    public User(String firstName ,String lastName,String userName,String pass){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=pass;
        this.products= Collections.<Product>emptyList();
        this.isDeleted=false;
    }
    public User(){}
    @Id
    @GeneratedValue
    private long id;

    @Column(name="user_is_deleted")
    private  Boolean isDeleted;

    @Column(name="user_first_name")
    private String firstName;

    @Column(name="user_last_name")
    private String lastName;

    @Column(name="user_user_name")
    private String userName;

    @Column(name="user_password")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Product> products;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
