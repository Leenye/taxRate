import java.util.ArrayList;
import java.util.Map;

/**
 * Created by twer on 9/4/15.
 */
public class Container {

    private double totalCosts = 0;
    private double totalTaxes = 0;
    private String key;
    private ArrayList<CartItem> cartItemArrayList = new ArrayList<CartItem>();

    public String getKey() {
        return key;
    }

    public ArrayList<CartItem> getCartItemArrayList() {
        return cartItemArrayList;
    }

    public double getTotalCosts() {
        return totalCosts;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setCartItemArrayList(ArrayList<CartItem> cartItemArrayList) {
        this.cartItemArrayList = cartItemArrayList;
    }

    public void setTotalCosts(double totalCosts) {
        this.totalCosts = totalCosts;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public double calculateTotalCosts(){
        for(CartItem i : cartItemArrayList){
            totalCosts += i.getGoods().getCost()*i.getNum();
        }
        return totalCosts;
    }

    public double calculateTotalTaxes(){
        for(CartItem i : cartItemArrayList){
            totalTaxes += i.getGoods().calculateTax()*i.getNum();
        }
        return totalTaxes;
    }

    public void printResults(){
        System.out.println(key);
        for (CartItem i : cartItemArrayList){
            System.out.println(i.getNum()+i.getGoods().getName()+": "+i.getGoods().getCost());
        }
        totalTaxes = this.calculateTotalTaxes();
        totalCosts = this.calculateTotalCosts();
        System.out.format("sales Taxes: %.2f%n", totalTaxes);
        System.out.format("Total: %.2f%n",totalCosts);
    }

    public void add(CartItem cartItem) {
        cartItemArrayList.add(cartItem);
    }
}
