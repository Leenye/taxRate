package com.homework.shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private double totalCosts;
    private double totalTaxes;
    private String date;
    private List<CartItem> cartItemList = new ArrayList<CartItem>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public void setProductDate(){
        for (CartItem cartItem : cartItemList){
            cartItem.getProduct().setDate(date);
        }
    }
}
