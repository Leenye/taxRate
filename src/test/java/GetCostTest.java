import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/3/15.
 */
public class GetCostTest {

    private Goods book = new Goods("book",12.49);
    private Goods musicCD = new Goods("music CD",14.99);
    private Goods importedPerfum = new Goods("imported perfum",27.99);

    @Test
    public void testGetCost(){
        assertThat((book.getCost()), is(12.49));
        assertThat((musicCD.getCost()),is(16.49));
        assertThat((importedPerfum.getCost()),is(32.19));
    }

}
