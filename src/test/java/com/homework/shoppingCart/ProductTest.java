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
    Product book = new Product("book",12.49);
    Product musicCD = new Product("music CD",14.99);
    Product importedPerfum = new Product("imported perfum",27.99);
    Product importedChocolate = new Product("imported chocolate",10.00);

    @Before
    public void setUp(){
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

    @After
    public void tearDown(){

    }

}