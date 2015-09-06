import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by twer on 9/6/15.
 */
public class ArrayListContentReader implements ContentReader {

    public ArrayList<Container> readContent(BufferedReader reader) {
        ArrayList<Container> containers = new ArrayList<Container>();
        CartItemParser cartItemParser = new CartItemParser();
        String line = null;
        Container container = null;
        boolean isContainerCreated = false;
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                if (isContainerCreated) {
                    containers.add(container);
                }
                return containers;
            } else {
                if (line.contains("Input")) {
                    if (isContainerCreated) {
                        containers.add(container);
                    }
                    container = new Container();
                    container.setKey(line);
                    isContainerCreated = true;
                } else {
                    container.add(cartItemParser.parseItem(line));
                }
            }
        }
    }
}
