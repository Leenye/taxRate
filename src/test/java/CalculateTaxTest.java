import com.homework.shoppingCart.helper.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/3/15.
 */
public class CalculateTaxTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception{
        calculator = new Calculator();
    }

    @Test
    public void testCalculatTax() {
        assertThat(calculator.calculateTax( 12.49,"book"), is(0.0));
        assertThat(calculator.calculateTax( 14.99,"music CD"), is(1.5));
        assertThat(calculator.calculateTax( 27.99,"imported perfum"), is(4.2));
    }

    @After
    public void tearDown() throws Exception {
    }
}
