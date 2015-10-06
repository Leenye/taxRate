package com.homework.shoppingCart.taxRate;

import java.util.ArrayList;
import java.util.List;

public class CompositeTaxRate extends TaxRate {

    private List<TaxRate> taxRateValues = new ArrayList<>();

    public CompositeTaxRate(TaxRate... taxRates){
        for (TaxRate rate:taxRates){
            taxRateValues.add(rate);
        }
    }

    public double getTaxRate(){
        int taxRate = 0;
        for (TaxRate rate: taxRateValues){
            taxRate += rate.getTaxRate();
        }
        return taxRate;
    }
}
