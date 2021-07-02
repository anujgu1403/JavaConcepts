package com.java.concepts.pattern.strategy;

public class ShoppingCartTest {

    public static void main(String []aa) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("3289", 10);
        Item item2 = new Item("32832239", 15);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.pay(new CreditCardPayStrategy("Anuj","231232", "121","0323"));
        cart.pay(new PalPalPayStrategy("anuj@gmail.com", "32e23"));
    }
}
