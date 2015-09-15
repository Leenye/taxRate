package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by twer on 9/4/15.
 */
public class CartItemParser {

    public CartItem parseItem(String item){
        Pattern pattern = Pattern.compile("(?<num>\\d)+(?<name>(\\s\\w*)+)\\sat\\s(?<price>.*)");
        Matcher matcher = pattern.matcher(item);

        if (matcher.find()) {
            String name = matcher.group("name");
            Double price = Double.parseDouble(matcher.group("price"));
            Product product = new Product(name, price);
            if (name.contains("imported")){
                product.setIsImported(true);
            }

            CartItem cartItem = new CartItem();
            String num = matcher.group("num");
            cartItem.setProduct(product);
            int number = Integer.parseInt(num);
            cartItem.setNum(number);
            return cartItem;
        }else {
            throw new IllegalArgumentException("Illegal item input");
        }
    }
}
