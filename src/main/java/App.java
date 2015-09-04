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
        TxtReaderHelper helper = new TxtReaderHelper();
        ArrayList<Container> containers = helper.readText();

        for (Container container : containers) {
            container.printResults();
        }
    }
}
