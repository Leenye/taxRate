package com.homework.shoppingCart.parse;

import com.homework.shoppingCart.Cart;
import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.Product;
import com.homework.shoppingCart.helper.ContentParseHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentParser {

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
                if(line.contains("Date")){
                    cart.setDate(line);
                    cart.setProductDate();
                    continue;
                }
                cart.add(parseItem(line));
            }
        }
        return carts;
    }

    private CartItem parseItem(String item) {
        Pattern pattern = Pattern.compile("(?<num>\\d)+\\s\\w+");
        Matcher matcher = pattern.matcher(item);
        if (matcher.find()) {
            CartItem cartItem = new CartItem();
            Product product = parseProduct(item);
            int number = Integer.parseInt(matcher.group("num"));
            cartItem.setProduct(product);
            cartItem.setNum(number);
            return cartItem;
        } else {
            throw new IllegalArgumentException("Illegal item input");
        }
    }

    private Product parseProduct(String item) {
        Pattern pattern = Pattern.compile("(?<name>(\\s\\w*)+)\\sat\\s(?<price>.*)");

        Matcher matcher = pattern.matcher(item);
        if (matcher.find()) {
            String name = matcher.group("name");
            Double price = Double.parseDouble(matcher.group("price"));
            Product product = new Product(name, price);
            if (name.contains("imported")) {
                product.setIsImported(true);
            }
            if (ContentParseHelper.isBasicExempt(name)) {
                product.setIsBasicExempt(true);
            }
            return product;
        } else {
            throw new IllegalArgumentException("Illegal item input");
        }
    }
}
