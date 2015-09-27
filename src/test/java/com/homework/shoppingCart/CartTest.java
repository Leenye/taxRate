package com.homework.shoppingCart;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CartTest {
    private Product product1;
    private Product product2;
    private CartItem cartItem1;
    private CartItem cartItem2;
    Cart cart;

    @Before
    public void setUp(){
        product1 = new Product("book",12.49,"Date: 2015-9-16 Wed",false,true);
        product2 = new Product("imported book",12.49,"Date: 2015-9-16 Wed",true,true);
        cartItem1 = new CartItem(product1,1);
        cartItem2 = new CartItem(product2,1);
        cart = new Cart();
        cart.add(cartItem1);
        cart.add(cartItem2);
        cart.setDate("Date: 2015-9-16 Wed");
        cart.setProductDate();
    }

    @Test
    public void testCalculateTotalTaxesInOneCart(){
        assertThat(cart.getTotalTaxes(), is(0.35));
    }

    @Test
    public void testCalculteTotalCostsInOneCart(){
        assertThat(cart.getTotalCosts(),is(25.33));
    }

    @Test
    public void testSetProductDateForProductsInOneCart() throws Exception {
        assertThat(product1.getDate(),is("Date: 2015-9-16 Wed"));
    }
}