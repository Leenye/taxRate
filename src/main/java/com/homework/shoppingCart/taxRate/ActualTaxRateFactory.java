package com.homework.shoppingCart.taxRate;

import com.homework.shoppingCart.product.Product;

public class ActualTaxRateFactory {
    static TaxRate domesticRate = new TaxRateNode(0.10);
    static TaxRate domesticExemp = new TaxRateNode(0.00);
    static TaxRate discountRate = new ImportedTaxRateNode(0.025);

    static TaxRate discountImportedBasic = new CompositeTaxRate(domesticRate, discountRate);
    static TaxRate discountImportedExempt = new CompositeTaxRate(domesticExemp, discountRate);

    public static TaxRate getActualTaxRate(Product product) {
        if (product.isBasicExempt()) {
            return discountImportedExempt ;
        } else {
            return discountImportedBasic;
        }
    }
}
