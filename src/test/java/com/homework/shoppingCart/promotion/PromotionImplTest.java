package com.homework.shoppingCart.promotion;

import com.homework.shoppingCart.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PromotionImplTest {

    Product book1;
    Product book2;
    Product book3;
    Product importedPerfume1;
    Product importedPerfume2;
    PromotionImpl promotion;

    @Before
    public void setUp(){
        book1 = new Product("book",12.49,"Date: 2015-9-1 Tue",false,true);
        book2 = new Product("book",12.49,"Date: 2015-9-1 Tue",false,true);
        book3 = new Product("imported book",12.49,"Date: 2015-9-1 Tue",false,true);

        importedPerfume1 = new Product("imported perfume",12.49,"Date: 2015-9-15 Tue",true,false);
        importedPerfume2 = new Product("imported perfume",12.49,"Date: 2015-9-16 Wed",true,false);

        book1.setStore("A");
        book2.setStore("B");
        book3.setStore("B");
    }

    @Test
    public void testHalfBookPriceDiscountPromotion() throws Exception {
        assertThat(book1.getSoldPrice(), is(6.25));
        assertThat(book2.getSoldPrice(), is(12.49));
        assertThat(book3.getSoldPrice(), is(12.49));
    }

    @Test
    public void testHalfImoportedTaxRateDiscountPromotion() throws Exception {
        assertThat(importedPerfume1.getActualTaxRate().getValue(), is(0.15));
        assertThat(importedPerfume2.getActualTaxRate().getValue(), is(0.125));
    }


}