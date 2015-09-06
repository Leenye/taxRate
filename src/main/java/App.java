import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by twer on 9/1/15.
 */
public class App {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.txt";
        TxtReaderHelper helper = new TxtReaderHelper();
        List<Container> containers = helper.readText(filePath);

        for (Container container : containers) {
            container.printResults();
        }
    }
}
