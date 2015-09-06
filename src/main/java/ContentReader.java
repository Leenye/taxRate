import java.io.BufferedReader;
import java.util.List;

/**
 * Created by twer on 9/6/15.
 */
public interface ContentReader {
    public List<Cart> readContent(BufferedReader reader);
}
