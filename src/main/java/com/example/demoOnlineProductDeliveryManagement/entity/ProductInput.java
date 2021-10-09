package com.example.demoOnlineProductDeliveryManagement.entity;

import java.util.Collections;
import java.util.List;

public class ProductInput {
    public  ProductInput(String name, int amount){
        this.name=name;
        this.amount= amount;

    }

    private  String name;
    private  int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
