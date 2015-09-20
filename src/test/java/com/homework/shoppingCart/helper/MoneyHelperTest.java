package com.homework.shoppingCart.helper;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyHelperTest {
    double value1 = 12.64;
    double value2 = 12.78;

    @Test
    public void testRound() throws Exception {
        assertThat(MoneyHelper.round(value1),is(12.65));
        assertThat(MoneyHelper.round(value2),is(12.80));
    }
}