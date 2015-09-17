package com.homework.shoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twer on 9/4/15.
 */
public class Cart {
    private double totalCosts = 0;
    private double totalTaxes = 0;
    private List<CartItem> cartItemList = new ArrayList<CartItem>();


    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(ArrayList<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void setTotalCosts(double totalCosts) {
        this.totalCosts = totalCosts;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public double getTotalCosts() {
        return Calculator.calculateTotalCost(cartItemList);
    }

    public double getTotalTaxes() {
        return Calculator.calculateTotalTax(cartItemList);
    }

    public void add(CartItem cartItem) {
        cartItemList.add(cartItem);
    }
}
