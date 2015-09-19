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
        product1 = new Product("book",12.49,"Date: Wen. 2015-9-18",false,true);
        product2 = new Product("imported book",12.49,"Date: Wen. 2015-9-18",true,true);
        cartItem1 = new CartItem(product1,1);
        cartItem2 = new CartItem(product2,1);
        cart = new Cart();
        cart.add(cartItem1);
        cart.add(cartItem2);
        cart.setDate("Date: Mon. 2015-9-18");
        cart.setProductDate();
    }

    @Test
    public void testCalculateTotalTaxes(){
        assertThat(cart.getTotalTaxes(), is(0.35));
    }

    @Test
    public void testCalculteTotalCosts(){
        assertThat(cart.getTotalCosts(),is(25.33));
    }

    @Test
    public void testSetProductDate() throws Exception {
        assertThat(product1.getDate(),is("Date: Mon. 2015-9-18"));
    }
}