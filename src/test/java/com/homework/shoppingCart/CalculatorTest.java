package com.homework.shoppingCart;

import com.homework.shoppingCart.Calculator;
import com.homework.shoppingCart.Cart;
import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.Product;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
    private Calculator calculator;
    Product product1;
    Product product2;
    Cart cart;
    CartItem cartItem1;
    CartItem cartItem2;

    @Before
    public void setUp(){
        calculator = new Calculator();
        product1 = new Product("book",12.49,"Date: Wen. 2015-9-18",false,true);
        product2 = new Product("imported book",12.49,"Date: Wen. 2015-9-18",true,true);
        cartItem1 = new CartItem(product1,1);
        cartItem2 = new CartItem(product2,1);
        cart = new Cart();
        cart.getCartItemList().add(cartItem1);
        cart.getCartItemList().add(cartItem2);
    }

    @Test
    public void testCalculateTax(){
        assertThat(Calculator.calculateTax(product1),is(0.00));
        assertThat(calculator.calculateTax(product2),is(0.35));
    }

    @Test
    public void testCalculateTotalCost() throws Exception {
        assertThat(calculator.calculateTotalCost(cart.getCartItemList()),is(25.33));
    }

    @Test
    public void testCalculateTotalTax() throws Exception {
        assertThat(calculator.calculateTotalTax(cart.getCartItemList()),is(0.35));
    }

    @After
    public void tearDown() throws Exception{

    }

}