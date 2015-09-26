package com.homework.shoppingCart;

import com.homework.shoppingCart.parse.ContentParser;
import java.io.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.txt";
        ContentParser paser = new ContentParser();
        List<Cart> carts = paser.parse(filePath);

        Receipt receipt = new Receipt();

        System.out.println("OUTPUT");
        for (Cart cart : carts){
            int index = carts.indexOf(cart)+1;
            receipt.printOutReceipt(cart);
        }
    }
}



