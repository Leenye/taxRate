import java.io.*;
import java.util.List;

/**
 * Created by twer on 9/1/15.
 */
public class App {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.txt";
        TxtReaderHelper helper = new TxtReaderHelper();
        List<Cart> carts = helper.readText(filePath);

        for (Cart cart : carts) {
            cart.printResults();
        }
    }
}
