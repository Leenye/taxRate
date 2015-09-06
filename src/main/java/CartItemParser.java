import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by twer on 9/4/15.
 */
public class CartItemParser {

    public CartItem parseItem(String item){
        Pattern pattern = Pattern.compile("(?<num>\\d)+(?<name>(\\s\\w*)+)\\sat\\s(?<price>.*)");
        Matcher matcher = pattern.matcher(item);

        if (matcher.find()) {
            CartItem cartItem = new CartItem();

            String name = matcher.group("name");
            Double price = Double.parseDouble(matcher.group("price"));
            Goods goods = new Goods(name, price);
            goods.calculateTaxRate();
            String num = matcher.group("num");

            cartItem.setGoods(goods);
            int numuber = Integer.parseInt(num);
            cartItem.setNum(numuber);
            return cartItem;
        }else {
            throw new IllegalArgumentException("Illegal item input");
        }
    }
}
