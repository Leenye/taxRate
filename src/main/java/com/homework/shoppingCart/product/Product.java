package com.homework.shoppingCart.product;

import com.homework.shoppingCart.helper.MoneyHelper;
import com.homework.shoppingCart.promotion.PromotionImpl;
import com.homework.shoppingCart.taxRate.TaxRate;
import com.homework.shoppingCart.taxRate.TaxRateFactory;

import java.math.BigDecimal;

public class Product {
    protected String name;
    protected String date;
    protected String store;
    protected double shelfPrice;
    protected double soldPrice;
    protected boolean isImported;
    protected boolean isBasicExempt;
    protected double tax;
    protected double cost;
    protected double discount;
    private TaxRate taxRate;
    private TaxRate actualTaxRate = taxRate;
    private PromotionImpl promotion = new PromotionImpl();

    public Product(){
    }
// 通过构造函数传入TaxRateFactory.getProductTaxRate()，但是构造函数很多。
// 如果很多个构造函数都有调用，那要在每个构造函数中都传入静态方法吗？
    public TaxRate getTaxRate() {
        return TaxRateFactory.getProductTaxRate(this);
    }

    public void setTaxRate(TaxRate taxRate) {
        this.taxRate = taxRate;
    }

    public Product(String name, double shelfPrice) {
        this.name = name;
        this.shelfPrice = shelfPrice;
    }

    public Product(String name, double shelfPrice,String date) {
        this.name = name;
        this.shelfPrice = shelfPrice;
        this.date = date;
    }

    public Product(String name, double shelfPrice, String date, boolean isImported, boolean isBasicExempt) {
        this.name = name;
        this.shelfPrice = shelfPrice;
        this.date = date;
        this.isImported = isImported;
        this.isBasicExempt = isBasicExempt;
    }

    public Product(String name, double shelfPrice, String date, boolean isImported, boolean isBasicExempt, String store) {
        this.name = name;
        this.shelfPrice = shelfPrice;
        this.date = date;
        this.isImported = isImported;
        this.isBasicExempt = isBasicExempt;
        this.store = store;
    }

    public boolean isBasicExempt() {
        return isBasicExempt;
    }

    public void setIsBasicExempt(boolean isBasicExempt) {
        this.isBasicExempt = isBasicExempt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setIsImported(boolean isImported) {
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public double getShelfPrice() {
        return shelfPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShelfPrice(double shelfPrice) {
        this.shelfPrice = shelfPrice;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        tax = getActualTaxRate().getValue()*getSoldPrice();
        return MoneyHelper.round(tax);
    }

    public TaxRate getActualTaxRate() {
        TaxRate taxRateAfterPromotion = promotion.setPromotion(this).actualTaxRate;
        return (taxRateAfterPromotion == null ? getTaxRate() : taxRateAfterPromotion);
    }

    public void setActualTaxRate(TaxRate actualTaxRate) {
        this.actualTaxRate = actualTaxRate;
    }


    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getSoldPrice() {
        double priceAfterPromotion = promotion.setPromotion(this).soldPrice;
        double price = priceAfterPromotion == 0 ? shelfPrice : priceAfterPromotion;
        return new BigDecimal(price).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getDiscount() {
        return promotion.setPromotion(this).discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getCost() {
        cost =getTax() + getSoldPrice();
        return new BigDecimal(cost).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
