package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.Cart;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by twer on 9/6/15.
 */
public class ArrayListContentReader implements ContentReader {

    public ArrayList<Cart> readContent(BufferedReader reader) {
        ArrayList<Cart> containers = new ArrayList<Cart>();
        CartItemParser cartItemParser = new CartItemParser();
        String line = null;
        Cart container = null;
        boolean isContainerCreated = false;
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                if (isContainerCreated) {
                    containers.add(container);
                }
                return containers;
            } else {
                if (line.contains("Input")) {
                    if (isContainerCreated) {
                        containers.add(container);
                    }
                    container = new Cart();
                    container.setKey(line);
                    isContainerCreated = true;
                } else {
                    container.add(cartItemParser.parseItem(line));
                }
            }
        }
    }
}
