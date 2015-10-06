package com.homework.shoppingCart.taxRate;

public class TaxRateNode extends TaxRate {
    double value;
    public TaxRateNode(double value){
        this.value = value;
    }

    public double getTaxRate(){
        return value;
    }
}
