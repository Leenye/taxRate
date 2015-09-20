package com.homework.shoppingCart.parse;

import com.homework.shoppingCart.Cart;
import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.Product;
import com.homework.shoppingCart.helper.ContentParseHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentParser {

    public List<Cart> parse(String filePath) throws IOException {
        List<String> contents = Files.readAllLines(Paths.get(filePath));

        ArrayList<Cart> carts = new ArrayList<Cart>();
        String parsedDate = null;
        Cart cart = null;
        for (String line : contents) {
            if (line.equals("INPUT")) {
                continue;
            }
            if (line.contains("Date")){
                parsedDate =line +" "+ parseWeekday(preProcessDate(line));
                continue;
            }
            if (line.contains("Input")) {
                cart = new Cart();
                cart.setDate(parsedDate);
                carts.add(cart);
            } else {
                cart.add(parseItem(line));
                cart.setProductDate();
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

    public String preProcessDate(String inputDate){
        String date = null;
        Pattern pattern = Pattern.compile("^Date:\\s(?<date>(\\d+-*)+)");
        Matcher matcher = pattern.matcher(inputDate);
        if (matcher.find()){
            date = matcher.group("date");
        }
        return date;
    }

    public  String parseWeekday(String date){
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("E");
        Date d = null;
        try {
            d = simpleDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(d);
    }

}
