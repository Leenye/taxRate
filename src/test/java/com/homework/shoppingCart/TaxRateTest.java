package com.homework.shoppingCart;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaxRateTest {
    Product product1;
    Product product2;
    Product product3;
    Product product4;
    Product product5;
    Product product6;

    @Before
    public void setUp(){
        product1 = new Product("book",12.49,"Date: 2015-9-16 Wed",false,true);
        product2 = new Product("imported book",12.49,"Date: 2015-9-16 Wed",true,true);
        product3 = new Product("perfume",12.49,"Date: 2015-9-16 Wed",false,false);
        product4 = new Product("imported perfume",12.49,"Date: 2015-9-16 Wed",true,false);
        product5 = new Product("imported perfume",12.49,"Date: 2015-9-15 Tue",true,false);
        product6 = new Product("imported book",12.49,"Date: 2015-9-17 Thu",true,true);
    }

    @Test
    public void testCalculateTaxRate() throws Exception {
        assertThat(TaxRate.calculateTaxRate(product1),is(0.00));
        assertThat(TaxRate.calculateTaxRate(product2),is(0.025));
        assertThat(TaxRate.calculateTaxRate(product3),is(0.10));
        assertThat(TaxRate.calculateTaxRate(product4),is(0.125));
        assertThat(TaxRate.calculateTaxRate(product5),is(0.15));
        assertThat(TaxRate.calculateTaxRate(product6),is(0.05));
    }
}