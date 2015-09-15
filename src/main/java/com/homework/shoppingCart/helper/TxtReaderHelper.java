package com.homework.shoppingCart.helper;

import com.homework.shoppingCart.Cart;

import java.io.*;
import java.util.List;

/**
 * Created by twer on 9/1/15.
 */
public class TxtReaderHelper {

    public List<Cart> readText(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ContentReader contentReader = new ContentReader();

        if (reader.readLine().equals("INPUT")) {
            List<Cart> containers =  contentReader.readContent(reader);
            reader.close();
            return containers;
        } else {
            reader.close();
            throw new IllegalArgumentException("Illegal input file");
        }
    }
}
