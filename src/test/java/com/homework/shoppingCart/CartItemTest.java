package com.homework.shoppingCart;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class CartItemTest extends TestCase {

    CartItem cartItem ;
    CartItem cartItemOnFisrtDay;
    Product book;
    Product bookSoldOnFisrtDay;

    @Before
    public void setUp(){
        book = new Product("book",12.49,"Date: 2015-9-16  Wed");
        bookSoldOnFisrtDay = new Product("book",12.49,"Date: 2015-9-1  Tue");
        bookSoldOnFisrtDay.setStore("A");
        cartItem = new CartItem(book,2);
        cartItemOnFisrtDay = new CartItem(bookSoldOnFisrtDay, 2);
    }

    @Test
    public void testGetItemSavedNotOnFirstMonthDate() throws Exception {
        assertThat(cartItem.getItemSaved(), is(0.00));
    }

    public void testBooksHalfPriceSavedOnTheFirstMonthDate() throws Exception {
        assertThat(cartItemOnFisrtDay.getItemSaved(), is(12.48));
    }
}