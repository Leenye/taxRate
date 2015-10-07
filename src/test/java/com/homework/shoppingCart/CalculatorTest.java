package com.homework.shoppingCart;

import com.homework.shoppingCart.Calculator;
import com.homework.shoppingCart.Cart;
import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.product.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
    Product product1;
    Product product2;
    Cart cart;
    CartItem cartItem1;
    CartItem cartItem2;

    @Before
    public void setUp(){
        product1 = new Product("book",12.49,"Date: 2015-9-16 Wed",false,true);
        product2 = new Product("imported book",12.49,"Date: 2015-9-16 Wed",true,true);
        cartItem1 = new CartItem(product1,1);
        cartItem2 = new CartItem(product2,1);
        cart = new Cart();
        cart.getCartItemList().add(cartItem1);
        cart.getCartItemList().add(cartItem2);
    }

    @Test
    public void testCalculateTotalCost() throws Exception {
        assertThat(Calculator.calculateTotalCost(cart.getCartItemList()),is(25.33));
    }

    @Test
    public void testCalculateTotalTax() throws Exception {
        assertThat(Calculator.calculateTotalTax(cart.getCartItemList()),is(0.35));
    }

    @After
    public void tearDown() throws Exception{

    }

}