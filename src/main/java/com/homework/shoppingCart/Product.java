package com.homework.shoppingCart;

import com.homework.shoppingCart.helper.Calculator;

import java.math.BigDecimal;

/**
 * Created by twer on 9/1/15.
 */
public class Product {
    private String name;
    private double price;
    private double tax;
    private double cost;
    private String type;


    private Calculator calculator = new Calculator();

    public Product(){
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTax() {
        double tax = calculator.calculateTax(price, name);
        return this.tax=tax;
    }

    public double getCost() {
        double tax = calculator.calculateTax(price, name);
        cost =new BigDecimal(tax + price).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return this.cost;
    }
}
