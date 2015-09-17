package com.homework.shoppingCart.helper;

public class MoneyHelper {
    public static double round(double rawTax) {
        double tax;
        double i = Math.rint(rawTax * 100);
        if (i % 10 == 0 || i % 10 == 5) {
            tax = i / 100;
        } else {
            tax = (i + 5 - i % 10 % 5) / 100;
        }
        return tax;
    }
}
