package com.homework.shoppingCart.taxRate;

public class ImportedTaxRateNode extends TaxRate {
    double value;
    public ImportedTaxRateNode(double value){
        this.value = value;
    }
//  set方法设置进口税率
//    public void setImportedValue(double value) {
//        this.value = value;
//    }

    public double getValue() {
        return value;
    }

    public double getTaxRate() {
        return value;
    }
}
