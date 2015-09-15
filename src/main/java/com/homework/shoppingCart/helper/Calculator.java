package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by twer on 9/6/15.
 */
public class Calculator {
    private static final double IMPORTED_ADDITION = 0.05;

    public static double calculateTaxRate(Product product){
        double taxRate = product.getProductType().getTaxRate();
        if (product.isImported()){
            taxRate += IMPORTED_ADDITION;
        }
        return taxRate;
    }

    public static double calculateTax(Product product){
        double tax;
        double rawTax = product.getPrice()*product.getTaxRate();
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
