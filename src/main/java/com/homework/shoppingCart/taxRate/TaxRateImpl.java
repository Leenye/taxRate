package com.homework.shoppingCart.taxRate;

public class TaxRateImpl {
    TaxRate importedRate = new ImportedTaxRateNode(0.05);
    TaxRate domesticRate = new TaxRateNode(0.10);
    TaxRate domesticExemp = new TaxRateNode(0.00);

//    public void setImportedRate(double value) {
//        this.importedRate.setImportedValue(value);
//    }

    public double getTaxRate() {

        TaxRate basicRate = new CompositeTaxRate(domesticRate);
        TaxRate basicExempt = new CompositeTaxRate(domesticExemp);
        TaxRate importedBasic = new CompositeTaxRate(domesticExemp, importedRate);
        TaxRate importedExempt = new CompositeTaxRate(domesticExemp, importedRate);
        double target = importedBasic.getTaxRate();
        return importedBasic.getTaxRate();
    }
}
