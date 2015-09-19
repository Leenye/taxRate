package com.homework.shoppingCart.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentParseHelper {
    public static boolean isBasicExempt(String productName){
        if(productName.contains("book") || productName.contains("chocolate") || productName.contains("pills")){
            return true;
        }
        return false;
    }

    public static boolean isDate(String input){
        Pattern pattern = Pattern.compile("(?<time>[\\w]{3}\\.)\\s(\\d+-)+");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return true;
        }
        return false;
    }
}
