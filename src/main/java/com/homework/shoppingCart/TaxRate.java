package com.homework.shoppingCart;

import java.util.stream.Stream;

public enum TaxRate {
    BASIC_RATE(0.1),EXEMPT_RATE(0.0);
    private double taxRate;
    private static double importedTaxRateAddition = 0.05;
    private static double importedTaxRateOff = 0.5;

    TaxRate(double taxRate){
        this.taxRate = taxRate;
    }
    public double getTaxRate(){
        return taxRate;
    }

    public static double calculateTaxRate(Product product){
        if(isHalfTaxOff(product.getDate())){
            importedTaxRateAddition = importedTaxRateOff*importedTaxRateAddition;
        }
        double taxRate = TaxRate.BASIC_RATE.getTaxRate();
        if (product.isBasicExempt()){
            taxRate = TaxRate.EXEMPT_RATE.getTaxRate();
        }
        if (product.isImported()){
            taxRate += importedTaxRateAddition;
        }
        importedTaxRateAddition = 0.05;
        return taxRate;
    }

    private static boolean isHalfTaxOff(String time){
        Stream<String> datesOff = Stream.of("Mon.", "Wen.", "Fri");
        String[] dates = {"Mon.","Tue.","Wen.","Thu.","Fri.","Sat.","Sun."};
        String date = Stream.of(dates).filter(i -> time.contains(i)).findFirst().get();
        if(datesOff.anyMatch(i->i.equals(date))){
            return true;
        }
        return false;
    }
}
