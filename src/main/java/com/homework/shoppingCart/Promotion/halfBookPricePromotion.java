package com.homework.shoppingCart.promotion;

import com.homework.shoppingCart.product.Product;

public class HalfBookPricePromotion implements Promotion {
    public Product setPromotion(Product product) {
        if (isHalfBookPricePromotion(product)){
            product.setSoldPrice(product.getShelfPrice() * 0.5);
        }
        return product;
    }

    private boolean isHalfBookPricePromotion(Product product){
        boolean flag = false;
        String date = product.getDate();
        String dateNum = date.split(" ")[1];
        String dateForJudge =  dateNum.split("-")[2];
        if (dateForJudge.equals("1") && product.getName().contains("book") && product.getStore().equals("A")){
            flag = true;
        }
        return flag;
    }
}
