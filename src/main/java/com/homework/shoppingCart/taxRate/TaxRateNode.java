package com.homework.shoppingCart.taxRate;

public class TaxRateNode implements TaxRate {
    double value;
    public TaxRateNode(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
