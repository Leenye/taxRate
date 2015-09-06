import java.util.ArrayList;

/**
 * Created by twer on 9/6/15.
 */
public class Calculator {

    private static double BASIC_TAX_RATE = 0.1;
    private static double EXEMPT_TAX_RATE = 0.0;
    private static double IMPORTED_BASIC_TAX_RATE = 0.15;
    private static double IMPORTED_EXEMPT_TAX_RATE = 0.05;

    private double taxrate;
    private double tax;
    public double calculateTax(double price,String name){
        double rawTax = price*calculateTaxRate(name);
        double i = Math.rint(rawTax*100);
        if (i%10 == 0 || i%10 == 5){
            tax =  i/100;
        }else {
            tax = (i + 5 - i%10%5)/100;
        }
        return tax;
    }

    public double calculateTaxRate(String name){
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

//    public double calculateTotal(ArrayList<CartItem> arrayList){
//        for (CartItem i: arrayList){
//
//        }
//    }
}
