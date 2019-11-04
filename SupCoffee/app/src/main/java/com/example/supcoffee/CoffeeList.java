package com.example.supcoffee;

import java.io.Serializable;
import java.util.ArrayList;

public class CoffeeList implements Serializable {

    private ArrayList<CoffeeObject> coffees;

    public CoffeeList(ArrayList<CoffeeObject> newCoffeeList) {
        this.coffees = newCoffeeList;
    }

    public ArrayList<CoffeeObject> getCoffees() {
        return coffees;
    }

    public void setCoffees(ArrayList<CoffeeObject> coffees) {
        this.coffees = coffees;
    }

    public void addCoffee(CoffeeObject newCoffee){
        this.coffees.add(newCoffee);
    }
}
