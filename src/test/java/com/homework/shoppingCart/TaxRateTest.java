package com.homework.shoppingCart;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by twer on 9/11/15.
 */
public class TaxRateTest extends TestCase {
    private TaxRate taxRate;

    @Before
    public void setUp() throws Exception{
        taxRate = new TaxRate();
    }

    @Test
    public void testCalculateTaxRate(){
        assertThat(taxRate.calculateTaxRate("imported chocolate"),is(0.05));
        Assert.assertThat(taxRate.calculateTaxRate("imported bottle of perfum"), is(0.15));
        Assert.assertThat(taxRate.calculateTaxRate("book"), is(0.0));
        Assert.assertThat(taxRate.calculateTaxRate("music CD"), is(0.1));
    }

    @After
    public void tearDown() throws Exception{
    }
}