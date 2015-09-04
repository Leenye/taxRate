import java.math.BigDecimal;

/**
 * Created by twer on 9/1/15.
 */
public class Goods {
    private String name;
    private double price;
    private double taxrate;
    private double tax;
    private double cost;
    private String type;
    

    public Goods(){
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double calculateTaxRate(){
        if (name.contains("imported")){
            if (name.contains("book") || name.contains("chocolate") || name.contains("pills")){
                taxrate = 0.05;
            }else {
                taxrate = 0.15;
            }
        }else {
            if (name.contains("book") || name.contains("chocolate") || name.contains("pills")){
                taxrate = 0.0;
            }else {
                taxrate = 0.1;
            }
        }
        return taxrate;
    }

    public double calculateTax(){
        double rawTax = this.price*this.calculateTaxRate();
        double i = Math.rint(rawTax*100);
        if (i%10 == 0 || i%10 == 5){
            tax =  i/100;
        }else {
            tax = (i + 5 - i%10%5)/100;
        }
        return tax;
    }

    public double getCost() {
        double tax = 0;
        double rawTax = this.price*this.calculateTaxRate();
        double i = Math.rint(rawTax*100);
        if (i%10 == 0 || i%10 == 5){
            tax =  i/100;
        }else {
            tax = (i + 5 - i%10%5)/100;
        }
        cost =new BigDecimal(tax + price).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return cost;
    }

    public Goods getGoodsByName(String name){
        Goods goods = new Goods();
        goods.setName(name);
        return goods;
    }

}
