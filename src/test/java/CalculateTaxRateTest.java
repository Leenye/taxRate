import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/3/15.
 */
public class CalculateTaxRateTest {
    private Goods importedFood = new Goods("imported chocolate", 12.75);
    private Goods importedPerfum = new Goods("imported bottle of perfum",32);
    private Goods book = new Goods("book",12.90);
    private Goods cd = new Goods("music CD",21.0);

    @Test
    public void testCalculateTaxRate(){
        assertThat(importedFood.calculateTaxRate(), is(0.05));
        assertThat(importedPerfum.calculateTaxRate(), is(0.15));
        assertThat(book.calculateTaxRate(), is(0.0));
        assertThat(cd.calculateTaxRate(), is(0.1));
    }

}
