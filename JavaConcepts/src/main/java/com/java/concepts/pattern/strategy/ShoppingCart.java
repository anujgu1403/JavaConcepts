package com.java.concepts.pattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int calCulateCartTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PayStrategy payStrategy){
        int total =calCulateCartTotal();
        payStrategy.pay(total);
    }
}
