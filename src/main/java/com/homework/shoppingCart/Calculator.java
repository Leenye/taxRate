package com.homework.shoppingCart;

import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.Product;
import com.homework.shoppingCart.helper.MoneyHelper;

import java.math.BigDecimal;
import java.util.List;

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
