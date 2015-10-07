package com.homework.shoppingCart.promotion;

import com.homework.shoppingCart.product.Product;
import com.homework.shoppingCart.taxRate.ActualTaxRateFactory;

import java.util.stream.Stream;

public class HalfImportedTaxRatePromotion implements Promotion {
    public Product setPromotion(Product product) {
        if (isHalfImportedTaxRatePromotion(product)){
            product.setActualTaxRate(ActualTaxRateFactory.getActualTaxRate(product));
//            product.setDiscount(product.getDiscount()+product.getShelfPrice()*0.5);
        }
        return product;
    }

//    如下，对促销的判断放在促销类中好吗？
    private boolean isHalfImportedTaxRatePromotion(Product product){
        boolean flag = false;
        String time = product.getDate();
        String[] dates = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        String date = Stream.of(dates).filter(i -> time.contains(i)).findFirst().get();
        Stream<String> daysImportedRateHalved = Stream.of("Mon", "Wed", "Fri");
        if(daysImportedRateHalved.anyMatch(i -> i.equals(date)) && product.getName().contains("imported")){
            flag = true;
        }
        return flag;

    }
}
