package com.homework.shoppingCart.taxRate;

import com.homework.shoppingCart.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaxRateTest {
    Product book;
    Product perfume;
    Product importedBook;
    Product importedPerfume;

    @Before
    public void setUp(){
        book = new Product("book",12.49,"Date: 2015-9-16  Wed",false,true);
        importedBook = new Product("imported book",12.49,"Date: 2015-9-17 Thu",true,true);
        perfume = new Product("perfume",12.49,"Date: 2015-9-16 Wed",false,false);
        importedPerfume = new Product("imported perfume",12.49,"Date: 2015-9-16 Wed",true,false);
    }

    @Test
    public void testGetBasicTaxRateBeforePromotion() throws Exception {
        assertThat(TaxRateFactory.getProductTaxRate(book).getValue(),is(0.00));
        assertThat(TaxRateFactory.getProductTaxRate(perfume).getValue(),is(0.10));
    }

    public void testGetImportedTaxRateBeforePromotion() throws Exception {
        assertThat(TaxRateFactory.getProductTaxRate(importedBook).getValue(),is(0.05));
        assertThat(TaxRateFactory.getProductTaxRate(importedPerfume).getValue(),is(0.15));
    }

    public void testGetBasicTaxRateAfterPromotion() throws Exception {
        assertThat(ActualTaxRateFactory.getActualTaxRate(book).getValue(),is(0.00));
        assertThat(ActualTaxRateFactory.getActualTaxRate(perfume).getValue(),is(0.10));
    }

    public void testGetImportedTaxRateAfterPromotion() throws Exception {
        assertThat(ActualTaxRateFactory.getActualTaxRate(importedBook).getValue(),is(0.025));
        assertThat(ActualTaxRateFactory.getActualTaxRate(importedPerfume).getValue(),is(0.125));
    }


}