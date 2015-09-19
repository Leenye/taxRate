package com.homework.shoppingCart;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/11/15.
 */
public class ProductTest extends TestCase {
    Product product1;
    Product product2;
    Product product3;
    Product product4;
    Product product5;
    Product product6;

    @Before
    public void setUp(){
        product1 = new Product("book",12.49,"Date: Wen. 2015-9-18",false,true);
        product2 = new Product("imported book",12.49,"Date: Wen. 2015-9-18",true,true);
        product3 = new Product("perfume",12.49,"Date: Wen. 2015-9-18",false,false);
        product4 = new Product("imported perfume",12.49,"Date: Wen. 2015-9-18",true,false);
        product5 = new Product("imported perfume",12.49,"Date: Tue. 2015-9-18",true,false);
        product6 = new Product("imported book",12.49,"Date: Thu. 2015-9-18",true,true);
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

    @Test
    public void testGetTax(){
        assertThat((product1.getTax()), is(0.00));
        assertThat((product2.getTax()), is(0.35));
        assertThat((product3.getTax()), is(1.25));
        assertThat((product4.getTax()), is(1.60));
        assertThat((product5.getTax()), is(1.90));
        assertThat((product6.getTax()), is(0.65));
    }

    @Test
    public void testGetTaxRate() throws Exception {
        assertThat(product1.getTaxRate(), is(0.00));
        assertThat(product2.getTaxRate(), is(0.025));
        assertThat(product3.getTaxRate(), is(0.10));
        assertThat(product4.getTaxRate(), is(0.125));
        assertThat(product5.getTaxRate(), is(0.15));
        assertThat(product6.getTaxRate(), is(0.05));
    }

    @After
    public void tearDown(){
    }
}