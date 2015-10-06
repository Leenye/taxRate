package com.homework.shoppingCart.taxRate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TaxRateImplTest {
    TaxRateImpl taxRate;
    @Before
    public void setUp(){
        taxRate = new TaxRateImpl();
    }

    @Test
    public void testGetTaxRate() throws Exception {
        assertThat(taxRate.getTaxRate(),is(0.15));

    }
}