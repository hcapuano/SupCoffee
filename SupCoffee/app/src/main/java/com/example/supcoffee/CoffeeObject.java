package com.example.supcoffee;

import java.io.Serializable;

public class CoffeeObject implements Serializable {

    private String listID;
    private String name;
    private String rate;

    public CoffeeObject(String coffeeName, String rate) {
        this.name = coffeeName;
        this.rate = rate;
    }

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String[] toArrayString() {
        return new String[]{
                listID,
                name,
                rate.toString(),
        };
    }
}