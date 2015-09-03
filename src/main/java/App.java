import java.io.*;
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
            while( (line = reader.readLine()) !=null) {
                System.out.println(line);

                Pattern pattern = Pattern.compile("(?<num>\\d)+(?<name>(\\s\\w*)+)\\sat\\s(?<price>.*)");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    String name = matcher.group("name");
                    Double price =Double.parseDouble(matcher.group("price")) ;
                    Goods product = new Goods(name,price);
                    product.getTaxRate();
                    System.out.println(product.getTaxRate());
                }
            }
        reader.close();
    }
}
