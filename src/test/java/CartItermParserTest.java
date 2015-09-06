import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/5/15.
 */
public class CartItermParserTest {

    String inputItem =  new String("1 imported box of chocolates at 10.00");
    private CartItemParser parser = new CartItemParser();
    Goods goods = new Goods("imported box of chocolates",10.00);
    CartItem cartItem = new CartItem(goods,1);

    @Test
    public void testCartItermParser(){
        assertThat(parser.parseItem(inputItem).getNum(),is(cartItem.getNum()));
    }
}
