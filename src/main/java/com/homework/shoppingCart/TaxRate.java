package com.homework.shoppingCart;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by twer on 9/10/15.
 */
public class TaxRate {
    private final static double BASIC_RATE = 0.1;
    private final static double EXEMPT_RATE = 0.0;
    private final static double IMPORTED_RATE_ADDITION = 0.05;

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
        double taxRate = BASIC_RATE;
        if(isExempt(name)){
            taxRate = EXEMPT_RATE;
        }

        if (isImported(name)){
            taxRate = taxRate + IMPORTED_RATE_ADDITION;
        }
        return new BigDecimal(taxRate).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
