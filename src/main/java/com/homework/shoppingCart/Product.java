package com.homework.shoppingCart;

import java.math.BigDecimal;

public class Product {
    private String name;
    private double price;
    private double cost;
    private boolean isImported;
    private boolean isBasicExempt;
    private String date;
//    private TaxRate taxRate;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public boolean isBasicExempt() {
        return isBasicExempt;
    }

    public void setIsBasicExempt(boolean isBasicExempt) {
        this.isBasicExempt = isBasicExempt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setIsImported(boolean isImported) {
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
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

    public double getTaxRate(){
      return  TaxRate.calculateTaxRate(this);
    }

    public double getTax(){
        double tax = Calculator.calculateTax(this);
        return new BigDecimal(tax).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getCost() {
        cost =new BigDecimal(this.getTax() + price).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return this.cost;
    }
}
