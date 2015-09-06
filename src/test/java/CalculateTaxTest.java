import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/3/15.
 */
public class CalculateTaxTest {

    private Goods book;
    private Goods musicCD;
    private Goods importedPerfum;

    @Before
    public void setUp() throws Exception {
        book = new Goods("book", 12.49);
        musicCD = new Goods("music CD", 14.99);
        importedPerfum = new Goods("imported perfum", 27.99);
    }

    @Test
    public void testCalculatTax() {
        assertThat(book.calculateTax(), is(0.0));
        assertThat(musicCD.calculateTax(), is(1.5));
        assertThat(importedPerfum.calculateTax(), is(4.2));
    }

    @After
    public void tearDown() throws Exception {
    }
}
