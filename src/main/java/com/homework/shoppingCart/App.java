package com.homework.shoppingCart;

import com.homework.shoppingCart.parse.CartParser;

import java.io.*;
import java.util.List;

/**
 * Created by twer on 9/1/15.
 */
public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.txt";
        CartParser paser = new CartParser();
        List<Cart> carts = paser.parse(filePath);

        for (Cart cart :carts){
           for (CartItem i : cart.getCartItemList()){
               System.out.println(i.getNum()+i.getProduct().getName()+": "+i.getProduct().getCost());
           }
           System.out.format("sales Taxes: %.2f%n", cart.getTotalTaxes());
           System.out.format("Total: %.2f%n",cart.getTotalCosts());
        }

//        String string = "Good Morning xiaoming";
//        Pattern pattern1 = Pattern.compile("(Good)\\s(?:Morning)\\s(xiaoming)");
//        Matcher matcher1 = pattern1.matcher(string);
//        matcher1.find();
//        matcher1.group(1).toString();
//        System.out.println(matcher1.group(2).toString());

    }
}
