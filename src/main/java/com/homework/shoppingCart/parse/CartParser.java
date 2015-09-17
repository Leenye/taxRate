package com.homework.shoppingCart.parse;

import com.homework.shoppingCart.Cart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CartParser {
    private CartItemParser cartItemParser;

    public CartParser() {
        cartItemParser = new CartItemParser();
    }

    public List<Cart> parse(String filePath) throws IOException {
        List<String> contents = Files.readAllLines(Paths.get(filePath));

        ArrayList<Cart> carts = new ArrayList<Cart>();
        Cart cart = null;
        for (String line : contents) {
            if (line.equals("INPUT")) {
                continue;
            }

            if (line.contains("Input")) {
                cart = new Cart();
                carts.add(cart);
            } else {
                cart.add(cartItemParser.parseItem(line));
            }
        }
        return carts;
    }
}
