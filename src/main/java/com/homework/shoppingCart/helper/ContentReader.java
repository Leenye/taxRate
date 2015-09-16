package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.Cart;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by twer on 9/6/15.
 */
public class ContentReader {

    public ArrayList<Cart> readContent(BufferedReader reader) {
        ArrayList<Cart> carts = new ArrayList<Cart>();
        CartItemParser cartItemParser = new CartItemParser();
        String line = null;
        Cart cart = null;
        boolean isContainerCreated = false;
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                if (isContainerCreated) {
                    carts.add(cart);
                }
                return carts;
            } else {
                if (line.contains("Input")) {
                    if (isContainerCreated) {
                        carts.add(cart);
                    }
                    cart = new Cart();
//                    cart.setKey(line);
                    isContainerCreated = true;
                } else {
                    cart.add(cartItemParser.parseItem(line));
                }
            }
        }
    }
}
