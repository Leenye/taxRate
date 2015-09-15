package com.homework.shoppingCart.helper;

/**
 * Created by twer on 9/15/15.
 */
public enum ProductType {
    
    BASIC_TYPE(0.1), EXEMPT_TYPE(0.0);
    private double taxRate;

    ProductType(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate(){
        return taxRate;
    }


}
