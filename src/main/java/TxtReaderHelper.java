import java.io.*;
import java.util.ArrayList;

/**
 * Created by twer on 9/1/15.
 */
public class TxtReaderHelper {

    public ArrayList<Container> readText() throws IOException {

        File file = new File("src/main/resources/file.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        if (reader.readLine().equals("INPUT")) {
            System.out.println("INPUT");
            ArrayList<Container> containers =  readContent(reader);
            reader.close();
            return containers;
        } else {
            reader.close();
            return null;
        }
    }

    private ArrayList<Container> readContent(BufferedReader reader) throws IOException {
        ArrayList<Container> containers = new ArrayList<Container>();
        CartItemParser cartItemParser = new CartItemParser();
        String line = null;
        Container container = null;
        boolean isContainerCreated = false;
        while (true) {
            line = reader.readLine();
            if (line == null) {
                System.out.println("quit");
                if (isContainerCreated) {
                    containers.add(container);
                }
                return containers;
            } else if (line.contains("Input")) {
                System.out.println(line);
                if (isContainerCreated) {
                    containers.add(container);
                }
                container = new Container();
                container.setKey(line);
                isContainerCreated = true;
            } else {
                System.out.println(line);
                container.add(cartItemParser.parseItem(line));
            }
        }
    }

}
