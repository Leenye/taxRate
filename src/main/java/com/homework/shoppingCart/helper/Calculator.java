package com.homework.shoppingCart.helper;

/**
 * Created by twer on 9/6/15.
 */
public class Calculator {

    private static double BASIC_TAX_RATE = 0.1;
    private static double EXEMPT_TAX_RATE = 0.0;
    private static double IMPORTED_BASIC_TAX_RATE = 0.15;
    private static double IMPORTED_EXEMPT_TAX_RATE = 0.05;

    private double taxRate;
    private double tax;

    private boolean isImported;
    private boolean isExempt;

    public boolean isImported(String name){
        boolean importedFlag = false;
        if (name.contains("imported")){
            importedFlag = true;
        }
        return importedFlag;
    }

    public boolean isExempt(String name){
        boolean ExemptFlag = false;
        if (name.contains("book") || name.contains("chocolate") || name.contains("pills")){
            ExemptFlag = true;
        }
        return ExemptFlag;
    }

    public double calculateTaxRate(String name){
        if (isImported(name)){
            double taxRate = 0.15;
            if(isExempt(name)){
                taxRate = 0.05;
            }
            return taxRate;
        }else{
            double taxRate = 0.1;
            if(isExempt(name)){
                taxRate = 0.0;
            }
            return taxRate;
        }
    }

    public double calculateTax(double price,String name){
        double rawTax = price*calculateTaxRate(name);
        double i = Math.rint(rawTax*100);
        if (i%10 == 0 || i%10 == 5){
            tax =  i/100;
        }else {
            tax = (i + 5 - i%10%5)/100;
        }
        return tax;
    }
}
