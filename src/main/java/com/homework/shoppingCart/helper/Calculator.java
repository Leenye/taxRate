package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.CartItem;

import java.math.BigDecimal;
import java.util.List;

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

    public static double calculateTotalCost(List<CartItem> cartItems){
        double totalCosts = 0;
        for(CartItem i : cartItems){
            totalCosts += i.getProduct().getCost()*i.getNum();
        }
        return new BigDecimal(totalCosts).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() ;
    }

    public static double calculateTotalTax(List<CartItem> cartItems){
        double totalTaxes = 0;
        for(CartItem i : cartItems){
            totalTaxes += i.getProduct().getTax()*i.getNum();
        }
        return new BigDecimal(totalTaxes).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}
