package com.homework.shoppingCart;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductTest {
    Product product1;
    Product product2;
    Product product3;
    Product product4;
    Product product5;
    Product product6;
    Product product7;

    @Before
    public void setUp(){
        product1 = new Product("book",12.49,"Date: 2015-9-16  Wed",false,true);
        product2 = new Product("imported book",12.49,"Date: 2015-9-16 Wed",true,true);
        product3 = new Product("perfume",12.49,"Date: 2015-9-16 Wed",false,false);
        product4 = new Product("imported perfume",12.49,"Date: 2015-9-16 Wed",true,false);
        product5 = new Product("imported perfume",12.49,"Date: 2015-9-15 Tue",true,false);
        product6 = new Product("imported book",12.49,"Date: 2015-9-17 Thu",true,true);
        product7 = new Product("book",12.49,"Date: 2015-9-1 Tue",false,true);
        product7.setStore("A");
    }

    @Test
    public void testGetTaxRate() throws Exception {
        assertThat(product1.getTaxRate(), is(0.00));
        assertThat(product3.getTaxRate(), is(0.10));
        assertThat(product4.getTaxRate(), is(0.125));
    }

    @Test
    public void testGetTaxWithRoundPrinciple(){
        assertThat((product1.getTax()), is(0.00));
        assertThat((product2.getTax()), is(0.35));
        assertThat((product3.getTax()), is(1.25));
        assertThat((product4.getTax()), is(1.60));
        assertThat((product5.getTax()), is(1.90));
        assertThat((product6.getTax()), is(0.65));
    }

    @Test
    public void testGetSoldPriceWithHalfShelfPriceOffOnTheFirstMonthDate() throws Exception {
        assertThat(product1.getSoldPrice(),is(12.49));
        assertThat(product7.getSoldPrice(),is(6.25));
    }

    @Test
    public void testGetCost(){
        assertThat((product1.getCost()), is(12.49));
        assertThat((product2.getCost()), is(12.84));
        assertThat((product3.getCost()), is(13.74));
        assertThat((product4.getCost()), is(14.09));
        assertThat((product5.getCost()), is(14.39));
        assertThat((product6.getCost()), is(13.14));
    }

    @After
    public void tearDown(){
    }
}