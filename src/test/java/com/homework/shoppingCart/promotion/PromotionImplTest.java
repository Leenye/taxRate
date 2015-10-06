package com.homework.shoppingCart.promotion;

import com.homework.shoppingCart.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PromotionImplTest {

    Product book1;
    Product book2;
    Product importedPerfume1;
    Product importedPerfume2;
    PromotionImpl promotion;

    @Before
    public void setUp(){
        book1 = new Product("book",12.49,"Date: 2015-9-1 Tue",false,true);
        book2 = new Product("book",12.49,"Date: 2015-9-1 Tue",false,true);
        importedPerfume1 = new Product("imported perfume",12.49,"Date: 2015-9-15 Tue",true,false);
        importedPerfume2 = new Product("imported perfume",12.49,"Date: 2015-9-16 Wed",true,false);

        book1.setStore("A");
        book2.setStore("B");
        promotion = new PromotionImpl();

    }

    @Test
    public void testBuildPromotion() throws Exception {
        promotion.doPromotion(book1);
        assertThat(book1.getSoldPrice(), is(6.245));

        promotion.doPromotion(book2);
        assertThat(book1.getSoldPrice(), is(12.49));

        promotion.doPromotion(importedPerfume1);
//        assertThat(importedPerfume1.getTaxRate(),is());



    }
}