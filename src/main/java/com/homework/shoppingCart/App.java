package com.homework.shoppingCart;

import com.homework.shoppingCart.parse.ContentParser;
import java.io.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.txt";
        ContentParser paser = new ContentParser();
        List<Cart> carts = paser.parse(filePath);

        System.out.println("OUTPUT");
        for (Cart cart : carts){
            int index = carts.indexOf(cart)+1;
            System.out.println("output"+ index);
            for (CartItem i : cart.getCartItemList()) {
                System.out.println(i.getNum() + i.getProduct().getName() + ": " + i.getProduct().getCost());
            }
            System.out.format("sales Taxes: %.2f%n", cart.getTotalTaxes());
            System.out.format("Total: %.2f%n", cart.getTotalCosts());
            System.out.println(cart.getDate());
        }
    }
}



