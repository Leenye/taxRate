package com.homework.shoppingCart.helper;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by twer on 9/11/15.
 */
public class CalculatorTest extends TestCase {
    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testCalculateTax(){
        assertThat(calculator.calculateTax(12.49,0.0),is(0.00));
        assertThat(calculator.calculateTax(14.99,0.1),is(1.50));
        assertThat(calculator.calculateTax(10.00,0.05),is(0.50));
        assertThat(calculator.calculateTax(27.99,0.15),is(4.20));
    }

    @After
    public void tearDown() throws Exception{

    }

}