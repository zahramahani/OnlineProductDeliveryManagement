package com.example.demoOnlineProductDeliveryManagement.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.util.LinkedList;

@Entity
@Table(name="table_order")
public class Order implements Serializable {
    private final LinkedList<Status> orderedStatus;

    public Order( String deliveryAddress){
        LinkedList<Status> orderedStatuses=new LinkedList<Status>();
        orderedStatuses.add(Status.WAITING);
        orderedStatuses.add(Status.PACKING);
        orderedStatuses.add(Status.DELIVERING);
        orderedStatuses.add(Status.DELIVERED);
        this.orderedStatus=orderedStatuses;

        this.deliveryAddress=deliveryAddress;
        this.currentStatus =Status.WAITING;
        Date date= new Date();
        long time = date.getTime();
        this.currentStatusTime=new Timestamp(time);
        this.allStatus="[ "+currentStatus+":"+currentStatusTime+" ]";
    }
    public Order(){
        LinkedList<Status> orderedStatuses=new LinkedList<Status>();
        orderedStatuses.add(Status.WAITING);
        orderedStatuses.add(Status.PACKING);
        orderedStatuses.add(Status.DELIVERING);
        orderedStatuses.add(Status.DELIVERED);
        this.orderedStatus=orderedStatuses;
    };



    @Id
    @GeneratedValue
    private long id;
    @Column(name="order_is_deleted")
    private  Boolean isDeleted;

    @CreationTimestamp
    private Timestamp orderDate;

    @UpdateTimestamp
    private Timestamp updated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name="order_delivery_address")
    private String  deliveryAddress;

    @Column(name="order_current_status")
    @Enumerated(EnumType.STRING)
    private Status  currentStatus;

    @Column(name="order_current_status_time")
    private Timestamp currentStatusTime;

    @Column(name="order_all_status")
    private String  allStatus;

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

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Timestamp getCurrentStatusTime() {
        return currentStatusTime;
    }

    public void setCurrentStatusTime(Timestamp currentStatusTime) {
        this.currentStatusTime = currentStatusTime;
    }

    public String getAllStatus() {
        return allStatus;
    }

    public void setAllStatus(String allStatus) {
        this.allStatus = allStatus;
    }
}