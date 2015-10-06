package com.homework.shoppingCart;

import com.homework.shoppingCart.parse.ContentParser;
import com.homework.shoppingCart.product.Product;

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

        Product product =new Product("imported book",12);
//        product.getPromotionInfo();
        System.out.println(product.getCost());
    }
}



