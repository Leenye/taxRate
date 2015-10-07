package com.homework.shoppingCart;

import com.homework.shoppingCart.helper.MoneyHelper;
import com.homework.shoppingCart.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    public static double calculateTotalDiscounts(CartItem cartItem){
        double totalDiscount = 0;
        totalDiscount =  getOneProductDiscount(cartItem.getProduct())* cartItem.getNum();
        return new BigDecimal(totalDiscount).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private static double getOneProductDiscount(Product product){
        double oneProductDiscount = (product.getShelfPrice() - product.getSoldPrice()+
                product.getShelfPrice()*product.getTaxRate().getValue() - product.getSoldPrice()*product.getActualTaxRate().getValue());
        return oneProductDiscount;
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
