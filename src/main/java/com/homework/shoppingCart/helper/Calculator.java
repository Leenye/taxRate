package com.homework.shoppingCart.helper;

/**
 * Created by twer on 9/6/15.
 */
public class Calculator {
    public static double calculateTax(double price,double taxRate){
        double tax;
        double rawTax = price*taxRate;
        double i = Math.rint(rawTax*100);
        if (i%10 == 0 || i%10 == 5){
            tax =  i/100;
        }else {
            tax = (i + 5 - i%10%5)/100;
        }
        return tax;
    }
}
