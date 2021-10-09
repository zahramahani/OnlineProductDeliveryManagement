package com.example.demoOnlineProductDeliveryManagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="table_tag")
public class Tag  implements Serializable {
    public Tag(String name){
        this.name=name;
    }
    @Id
    @GeneratedValue
    private long id;

    @Column(name="tag_is_deleted")
    private  Boolean isDeleted;

    @Column(name="tag_name")
    private String name;

    @ManyToMany(mappedBy = "tags")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
