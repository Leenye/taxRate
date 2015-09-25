package com.homework.shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private double totalCosts;
    private double totalTaxes;
    private String date;
    private  String store;
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

    public double getTotalCosts() {
        return Calculator.calculateTotalCost(cartItemList);
    }

    public double getTotalTaxes() {
        return Calculator.calculateTotalTax(cartItemList);
    }

    public void add(CartItem cartItem) {
        cartItemList.add(cartItem);
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setProductDate(){
        for (CartItem cartItem : cartItemList){
            cartItem.getProduct().setDate(date);
        }
    }

    public void setProductStore(){
        for(CartItem cartItem : cartItemList){
            cartItem.getProduct().setStore(store);
        }
    }
}
