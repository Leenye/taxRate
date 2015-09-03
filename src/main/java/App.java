import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by twer on 9/1/15.
 */
public class App {

    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line = reader.readLine()) != null) {
            ArrayList<CartItem> cartItemArrayList = new ArrayList<CartItem>();

            if (line.contains("Input")) {
                CartItem cartItem = new CartItem();
                cartItemArrayList.add(cartItem);
            }

            Pattern pattern = Pattern.compile("(?<num>\\d)+(?<name>(\\s\\w*)+)\\sat\\s(?<price>.*)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String name = matcher.group("name");
                Double price = Double.parseDouble(matcher.group("price"));
                Goods goods = new Goods(name, price);
                goods.calculateTaxRate();

                String num = matcher.group("num");
            }

        }
        reader.close();

    }
}
