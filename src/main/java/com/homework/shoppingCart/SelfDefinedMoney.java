package com.homework.shoppingCart;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import java.util.Currency;

/**
 * Created by twer on 9/9/15.
 */
public class SelfDefinedMoney {
    private double quantity;
    private Currency currency;

    public SelfDefinedMoney(double quantity, Currency currency) {
        this.quantity = quantity;
        this.currency = currency;
    }

    public SelfDefinedMoney() {
    }

    public double getQuantity() {
        return quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    Currency usCurrency = Currency.getInstance("USD");


    public SelfDefinedMoney calculateCNYToUSD(Currency usCurrency){
        double rate = 6;
        double before = this.getQuantity();
        double after = before/rate;
        SelfDefinedMoney usMoney = new SelfDefinedMoney(after,usCurrency);
      return usMoney;
    }

    CurrencyUnit usDollar = MonetaryCurrencies.getCurrency("USD");
    MonetaryAmount tenUsDollar = Money.of(10, "USD");

}
