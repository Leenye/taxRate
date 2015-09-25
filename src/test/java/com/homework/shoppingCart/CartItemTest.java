package com.homework.shoppingCart;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CartItemTest {

    CartItem cartItem ;
    Product book;

    @Before
    public void setUp(){
        book = new Product("book",12.49,"Date: 2015-9-16  Wed");
        cartItem = new CartItem(book,2);
    }

    @Test
    public void testGetItemSaved() throws Exception {
        assertThat((cartItem.getItemSaved()), CoreMatchers.is(12.50));

    }
}