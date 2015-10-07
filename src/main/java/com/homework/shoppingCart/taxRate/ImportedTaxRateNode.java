package com.homework.shoppingCart.taxRate;

public class ImportedTaxRateNode implements TaxRate {
    double value;
    public ImportedTaxRateNode(double value){
        this.value = value;
    }
    public double getValue() {
        return value;
    }
}
