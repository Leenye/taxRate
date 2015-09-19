package com.homework.shoppingCart;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/11/15.
 */
public class CartTest extends TestCase {
    private Product goods1 = new Product("book",12.49);
    private Product goods2 = new Product("music CD",14.99);

    private CartItem cartItem1 = new CartItem(goods1,1);
    private CartItem cartItem2 = new CartItem(goods2,1);

    Cart cart;

    @Before
    public void setUp(){
        cart = new Cart();
        cart.add(cartItem1);
        cart.add(cartItem2);
        cart.setDate("Mon. 2015-9-18");
    }

    @Test
    public void testCalculateTotalTaxes(){
        assertThat(cart.getTotalTaxes(), is(1.50));
    }

    @Test
    public void testCalculteTotalCosts(){
        assertThat(cart.getTotalCosts(),is(28.98));
    }

    @Test
    public void testSetProductDate() throws Exception {
        assertThat(goods1.getDate(),is("Mon. 2015-9-18"));

    }
}