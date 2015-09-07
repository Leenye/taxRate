import com.homework.shoppingCart.Product;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/3/15.
 */
public class GetCostTest {

    private Product book = new Product("book",12.49);
    private Product musicCD = new Product("music CD",14.99);
    private Product importedPerfum = new Product("imported perfum",27.99);

    @Test
    public void testGetCost(){
        assertThat((book.getCost()), is(12.49));
        assertThat((musicCD.getCost()),is(16.49));
        assertThat((importedPerfum.getCost()),is(32.19));
    }
}
