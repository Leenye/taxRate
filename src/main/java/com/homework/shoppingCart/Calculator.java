package com.homework.shoppingCart;

import com.homework.shoppingCart.helper.MoneyHelper;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    public static double calculateTax(Product product){
        return MoneyHelper.round(product.getPrice() * product.getTaxRate());
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
