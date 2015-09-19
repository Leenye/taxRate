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
    Product book;
    Product musicCD;
    Product importedPerfum;
    Product importedChocolate;

    @Before
    public void setUp(){
        book = new Product("book",12.49);
        musicCD = new Product("music CD",14.99);
        importedPerfum = new Product("imported perfum",27.99);
        importedChocolate = new Product("imported chocolate",10.00);
        importedChocolate.setDate("Mon. 2015-9-18");
        musicCD.setDate("Wen. 2015-9-18");
        importedChocolate.setDate("Fri. 2015-9-18");
    }

    @Test
    public void testGetCost(){
        assertThat((book.getCost()), is(12.49));
        assertThat((musicCD.getCost()),is(16.49));
        assertThat((importedPerfum.getCost()),is(32.19));
        assertThat(importedChocolate.getCost(),is(10.50));
    }

    @Test
    public void testGetTax(){
        assertThat((book.getTax()), is(0.00));
        assertThat((musicCD.getTax()), is(1.50));
        assertThat((importedPerfum.getTax()),is(4.20));
        assertThat(importedChocolate.getTax(),is(0.50));
    }

    @Test
    public void testGetTaxRate() throws Exception {
        assertThat((book.getTaxRate()), is(0.00));
        assertThat((musicCD.getTaxRate()), is(0.10));
        assertThat((importedPerfum.getTaxRate()),is(0.125));
        assertThat(importedChocolate.getTaxRate(),is(0.025));
    }

    @After
    public void tearDown(){

    }


}