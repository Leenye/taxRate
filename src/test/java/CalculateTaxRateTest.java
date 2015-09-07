import com.homework.shoppingCart.helper.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 9/3/15.
 */
public class CalculateTaxRateTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception{
        calculator = new Calculator();
    }

    @Test
    public void testCalculateTaxRate(){
        assertThat(calculator.calculateTaxRate("imported chocolate"),is(0.05));
        assertThat(calculator.calculateTaxRate("imported bottle of perfum"), is(0.15));
        assertThat(calculator.calculateTaxRate("book"), is(0.0));
        assertThat(calculator.calculateTaxRate("music CD"), is(0.1));
    }

    @After
    public void tearDown() throws Exception{

    }
}
