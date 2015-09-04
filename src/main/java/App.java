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
       ArrayList<Container> containers =  helper.readText();
        for ( Container container : containers){
            container.printResults();
        }

//        File file = new File("file.txt");
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        String line = null;
//
//
//        ArrayList<Container> containers  = new ArrayList<Container>();
//
////        while ((line = reader.readLine()) != null){
////
////            if (line.contains("Input")){
////                Container container = new Container();
////                container.setKey(line);
////            }else{
////                container.getInputList().add(line);
////
////            }
////
////        }


//        ArrayList<CartItem> cartItemArrayList = new ArrayList<CartItem>();
//
//        double totalCosts = 0;
//        double totalTaxes = 0;
//
//        while ((line = reader.readLine()) != null) {
//
//            Pattern pattern = Pattern.compile("(?<num>\\d)+(?<name>(\\s\\w*)+)\\sat\\s(?<price>.*)");
//            Matcher matcher = pattern.matcher(line);
//
//            while (matcher.find()) {
//                String name = matcher.group("name");
//                Double price = Double.parseDouble(matcher.group("price"));
//                Goods goods = new Goods(name, price);
//                goods.calculateTaxRate();
//                String num = matcher.group("num");
//
//                CartItem cartItem = new CartItem();
//                cartItem.setGoods(goods);
//                int numuber = Integer.parseInt(num);
//                cartItem.setNum(numuber);
//
//                cartItemArrayList.add(cartItem);
//            }
//        }
//        reader.close();
//
//        for (CartItem i : cartItemArrayList){
//            totalCosts += i.getGoods().getCost()*i.getNum();
//            totalTaxes += i.getGoods().calculateTax()*i.getNum();
//            System.out.println(i.getNum()+i.getGoods().getName()+": "+i.getGoods().getCost());
//        }
//
//        System.out.println("sales Taxes: "+ totalTaxes);
//        System.out.println("Total: "+totalCosts);
//
    }
}
