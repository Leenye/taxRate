package com.homework.shoppingCart;

import com.homework.shoppingCart.CartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by twer on 9/4/15.
 */
public class Cart {
    private double totalCosts = 0;
    private double totalTaxes = 0;
    private String key;
    private ArrayList<CartItem> cartItemArrayList = new ArrayList<CartItem>();

    public String getKey() {
        return key;
    }

    public ArrayList<CartItem> getCartItemArrayList() {
        return cartItemArrayList;
    }

    public double getTotalCosts() {
        return totalCosts;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setCartItemArrayList(ArrayList<CartItem> cartItemArrayList) {
        this.cartItemArrayList = cartItemArrayList;
    }

    public void setTotalCosts(double totalCosts) {
        this.totalCosts = totalCosts;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public double calculateTotalCosts(){
        for(CartItem i : cartItemArrayList){
            totalCosts += i.getProduct().getCost()*i.getNum();
        }
        return new BigDecimal(totalCosts).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() ;
    }

    public double calculateTotalTaxes(){
        for(CartItem i : cartItemArrayList){
            totalTaxes += i.getProduct().getTax()*i.getNum();
        }
        return new BigDecimal(totalTaxes).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void printResults(){
        System.out.println(key);
        for (CartItem i : cartItemArrayList){
            System.out.println(i.getNum()+i.getProduct().getName()+": "+i.getProduct().getCost());
        }
        totalTaxes = this.calculateTotalTaxes();
        totalCosts = this.calculateTotalCosts();
        System.out.format("sales Taxes: %.2f%n", totalTaxes);
        System.out.format("Total: %.2f%n",totalCosts);
    }

    public void add(CartItem cartItem) {
        cartItemArrayList.add(cartItem);
    }
}
