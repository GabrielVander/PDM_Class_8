package com.example.class8.Model;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private Integer amount;

    public Item() {
    }

    public Item(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}