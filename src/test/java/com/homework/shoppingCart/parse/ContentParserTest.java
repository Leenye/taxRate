package com.homework.shoppingCart.parse;

import com.homework.shoppingCart.Cart;
import com.homework.shoppingCart.CartItem;
import com.homework.shoppingCart.Product;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContentParserTest extends TestCase {
    String filePath = "src/test/resources/testfile.txt";
    List<String> contents = new ArrayList<>();

    ContentParser contentParser;
    Product product;
    CartItem cartItem;
    String date= "Date: 2015-09-17";

    @Before
    public void setUp(){
        contentParser = new ContentParser();
        product = new Product(" book", 12.49, "Date: 2015-9-7 Mon");
        cartItem = new CartItem(product,1);
    }

    @Test
    public void testParse() throws Exception {
        List<Cart> carts = contentParser.parse(filePath);
        assertThat(carts.size(),is(1));
        assertThat(carts.get(0).getDate(), is("Date: 2015-9-7 Mon"));
        assertThat (carts.get(0).getCartItemList().get(0).getProduct().getName(),is(product.getName()));
        assertThat (carts.get(0).getCartItemList().get(0).getProduct().isBasicExempt(),is(true));
        assertThat (carts.get(0).getCartItemList().get(0).getProduct().isImported(),is(false));
    }

    public void testPreProcessDate() throws Exception {
        assertThat(contentParser.preProcessDate(date),is("2015-09-17"));

    }

    public void testParseWeekday() throws Exception {
        assertThat(contentParser.parseWeekday(contentParser.preProcessDate(date)),is("Thu"));
    }


}