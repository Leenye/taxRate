import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/3/15.
 */
public class CalculateTaxTest {
    private Goods book = new Goods("book",12.49);
    private Goods musicCD = new Goods("music CD",14.99);
    private Goods importedPerfum = new Goods("imported perfum",27.99);

    @Test
    public void testCalculatTax(){
        assertThat(book.calculateTax() ,is(0.0));
        assertThat(musicCD.calculateTax(),is(1.5));
        assertThat(importedPerfum.calculateTax(),is(4.2));
    }
}
