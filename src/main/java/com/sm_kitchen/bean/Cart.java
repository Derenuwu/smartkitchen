package com.sm_kitchen.bean;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Dish> items;
    private double total;

    public Cart() {
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public List<Dish> getItems() {
        return items;
    }

    public void setItems(List<Dish> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public Dish[] getItemsArray() {
        return items.toArray(new Dish[0]);
    }
    

}