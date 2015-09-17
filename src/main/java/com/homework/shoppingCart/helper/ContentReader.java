package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.Cart;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class ContentReader {

    public ArrayList<Cart> readContent(BufferedReader reader) throws IOException {
        ArrayList<Cart> carts = new ArrayList<Cart>();
        CartItemParser cartItemParser = new CartItemParser();
        Cart cart = null;

        List<String> content = readAllLines(reader);
        for (String line : content) {
            if (line.contains("Input")) {
                cart = new Cart();
                carts.add(cart);
            } else {
                cart.add(cartItemParser.parseItem(line));
            }
        }
        return carts;
    }

    private static List<String> readAllLines(BufferedReader reader) throws IOException {
        List<String> content = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            content.add(line);
            line = reader.readLine();
        }
        return content;
    }
}
