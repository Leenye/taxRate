package com.homework.shoppingCart;

import com.homework.shoppingCart.helper.Calculator;

import java.math.BigDecimal;
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

    public void printResults(){
//        System.out.println(key);
        for (CartItem i : cartItemList){
            System.out.println(i.getNum()+i.getProduct().getName()+": "+i.getProduct().getCost());
        }
        totalTaxes = this.getTotalTaxes();
        totalCosts = this.getTotalCosts();
        System.out.format("sales Taxes: %.2f%n", totalTaxes);
        System.out.format("Total: %.2f%n",totalCosts);
    }

    public void add(CartItem cartItem) {
        cartItemList.add(cartItem);
    }
}
