package com.homework.shoppingCart.helper;

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

/**
 * Created by twer on 9/11/15.
 */
public class CalculatorTest extends TestCase {
    private Calculator calculator;
    Product book;
    Product musicCD;
    Product importedPerfum;
    Product importedChocolate;
    CartItem cartItem1;
    CartItem cartItem2;
    Cart cart;
    List<CartItem> cartItemList;

    @Before
    public void setUp(){
        calculator = new Calculator();
        book = new Product("book",12.49);
        musicCD = new Product("music CD",14.99);
        importedPerfum = new Product("imported perfum",27.99);
        importedChocolate = new Product("imported chocolate",10.00);
        cartItem1 = new CartItem(book,1);
        cartItem2 = new CartItem(musicCD,1);
        cartItemList = new ArrayList<CartItem>();
        cartItemList.add(cartItem1);
        cartItemList.add(cartItem2);
    }

    @Test
    public void testCalculateTax(){
        assertThat(calculator.calculateTax(book),is(0.00));
        assertThat(calculator.calculateTax(musicCD),is(1.50));
        assertThat(calculator.calculateTax(importedChocolate),is(0.50));
        assertThat(calculator.calculateTax(importedPerfum),is(4.20));
    }

    @Test
    public void testCalculateTaxRate() throws Exception {
        assertThat(calculator.calculateTaxRate(book),is(0.00));
        assertThat(calculator.calculateTaxRate(musicCD),is(0.10));
        assertThat(calculator.calculateTaxRate(importedChocolate),is(0.50));
        assertThat(calculator.calculateTaxRate(importedPerfum),is(1.50));
    }

    @Test
    public void testCalculateTotalCost() throws Exception {
        assertThat(calculator.calculateTotalCost(cartItemList),is(28.98));


    }

    @Test
    public void testCalculateTotalTax() throws Exception {
        assertThat(calculator.calculateTotalTax(cartItemList),is(1.50));
    }

    @After
    public void tearDown() throws Exception{

    }

}