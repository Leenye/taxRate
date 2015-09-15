package com.homework.shoppingCart;

import com.homework.shoppingCart.helper.TxtReaderHelper;

import java.io.*;
import java.util.Currency;
import java.util.List;

/**
 * Created by twer on 9/1/15.
 */
public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.txt";
        TxtReaderHelper helper = new TxtReaderHelper();
        List<Cart> carts = helper.readText(filePath);

        for (Cart cart :carts){
           for (CartItem i : cart.getCartItemList()){
               System.out.println(i.getNum()+i.getProduct().getName()+": "+i.getProduct().getCost());
           }
           System.out.format("sales Taxes: %.2f%n", cart.getTotalTaxes());
           System.out.format("Total: %.2f%n",cart.getTotalCosts());
        }
    }
}
