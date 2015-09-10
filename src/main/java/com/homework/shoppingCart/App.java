package com.homework.shoppingCart;

import com.homework.shoppingCart.helper.TxtReaderHelper;

import java.io.*;
import java.util.Currency;
import java.util.List;

/**
 * Created by twer on 9/1/15.
 */
public class App {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.txt";
        TxtReaderHelper helper = new TxtReaderHelper();
        List<Cart> carts = helper.readText(filePath);

        for (Cart cart : carts) {
            cart.printResults();
        }

//        Currency usCurrency = Currency.getInstance("USD");
//        SelfDefinedMoney chinesMoney = new SelfDefinedMoney(50, Currency.getInstance("CNY"));
//        SelfDefinedMoney usMoney = chinesMoney.calculateCNYToUSD(usCurrency);
//        System.out.println("转为美元：" + usMoney.getQuantity() +
//                " 货币显示名：" + usCurrency.getDisplayName() +
//                " 货币代码：" + usMoney.getCurrency().getCurrencyCode() +
//                " 数字代码" + usMoney.getCurrency().getNumericCode() +
//                " 默认小数位：" + usCurrency.getDefaultFractionDigits());
    }

}
