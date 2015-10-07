package com.homework.shoppingCart.taxRate;

import com.homework.shoppingCart.product.Product;

public class TaxRateFactory {
    static TaxRate domesticRate = new TaxRateNode(0.10);
    static TaxRate domesticExempt = new TaxRateNode(0.00);
    static TaxRate importedRate = new ImportedTaxRateNode(0.05);
    static TaxRate discountRate = new ImportedTaxRateNode(0.025);

    static TaxRate basicRate = new CompositeTaxRate(domesticRate);
    static TaxRate basicExempt = new CompositeTaxRate(domesticExempt);
    static TaxRate importedBasic = new CompositeTaxRate(domesticRate, importedRate);
    static TaxRate importedExempt = new CompositeTaxRate(domesticExempt, importedRate);

    public static TaxRate getProductTaxRate(Product product){
        if (product.isImported()){
            if (product.isBasicExempt()){
               return importedExempt;
            }else {
               return importedBasic;
            }
        }else {
            if (product.isBasicExempt()){
                return basicExempt;
            }else {
                return basicRate;
            }
        }
    }
}
