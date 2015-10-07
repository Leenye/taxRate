package com.homework.shoppingCart.promotion;

import com.homework.shoppingCart.product.Product;

import java.util.ArrayList;
import java.util.List;

public class PromotionImpl implements Promotion {
    List<Promotion> promotionList = new ArrayList<>();
    Product promotionProduct;
    public Product setPromotion(Product product){

//        有别的办法添加每一个接口的实现吗？
        promotionList.add(new HalfBookPricePromotion());
        promotionList.add(new HalfImportedTaxRatePromotion());

        for (Promotion promotion : promotionList){
            promotionProduct = promotion.setPromotion(product);
        }

/*       返回了修改后的对象。而在setPromotion方法中就没有返回对象。
那么，对一个对象做了修改后，可以返回这个类，也可以不返回。如果返回的话，清晰的知道，
对象经过这个类后有了哪些改变，而且可以直接调用修改后的类，不会和最初的对象相混淆。
返回好还是不返回好？什么时候返回，什么时候不返回*/
//        这里的输出还是输入参数
        return promotionProduct;
    }
}
