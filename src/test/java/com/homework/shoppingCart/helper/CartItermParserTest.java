package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.helper.CartItemParser;
import com.homework.shoppingCart.Product;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/5/15.
 */
public class CartItermParserTest {

    String inputItem =  new String("1 imported box of chocolates at 10.00");
    private CartItemParser parser = new CartItemParser();
    Product importedChocolate = new Product("imported box of chocolates",10.00);
    CartItem cartItem = new CartItem(importedChocolate,1);

    @Test
    public void testCartItermParser(){
        assertThat(parser.parseItem(inputItem).getNum(),is(cartItem.getNum()));
    }
}
