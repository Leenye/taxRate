import org.junit.Test;

/**
 * Created by twer on 9/4/15.
 */
public class GetGoodsByNameTest {
    private Goods importedFood = new Goods("imported chocolate", 12.75);

    @Test
    public void testGetGoodsByName(){
       Goods goods = importedFood.getGoodsByName("imported chocolate");
    }
}
