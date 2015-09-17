package com.homework.shoppingCart;

import com.homework.shoppingCart.helper.ProductTypeHelper;

import java.math.BigDecimal;

/**
 * Created by twer on 9/1/15.
 */
public class Product {
    private String name;
    private double price;
    private double cost;
    private ProductType productType;
    private boolean isImported;

    public Product(){
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setIsImported(boolean isImported) {
        this.isImported = isImported;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductType getProductType(){
        return ProductTypeHelper.getProductType(name);
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
      return  Calculator.calculateTaxRate(this);
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
