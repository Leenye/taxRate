package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.ProductType;

/**
 * Created by twer on 9/16/15.
 */
public class ProductTypeHelper {
    public static ProductType getProductType(String productName){
        if(productName.contains("book") || productName.contains("chocolate") || productName.contains("pills")){
            return ProductType.EXEMPT_TYPE;
        }
        return ProductType.BASIC_TYPE;
    }
}
