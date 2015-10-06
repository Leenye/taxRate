package com.homework.shoppingCart.product;

import com.homework.shoppingCart.Calculator;
import com.homework.shoppingCart.TaxRate;
import com.homework.shoppingCart.promotion.PromotionImpl;

import java.math.BigDecimal;

public class Product {
    protected String name;
    protected String date;
    protected String store;
    protected double shelfPrice;
    protected double soldPrice;
    protected boolean isImported;
    protected boolean isBasicExempt;
    protected TaxRate taxRate;
    protected double tax;
    protected double cost;
    protected double discount;

    public Product(){
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

    public void setTaxRate(TaxRate taxRate) {
        this.taxRate = taxRate;
    }


    public double getTaxRate(){
      return  TaxRate.calculateTaxRate(this);
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTax(){
        double tax = Calculator.calculateTax(this);
        return new BigDecimal(tax).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getCost() {
        cost =new BigDecimal(this.getTax() + soldPrice).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return this.cost;
    }


    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    //    public double getSoldPrice() {
//        soldPrice = shelfPrice;
//        if (getIsHalfPriceOff()){
//            soldPrice = shelfPrice*0.5;
//        }
//        return new BigDecimal(soldPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//    }


//    private boolean getIsHalfPriceOff(){
//        boolean flag = false;
//        String dateNum = date.split(" ")[1];
//        String dateForJudge =  dateNum.split("-")[2];
//        if (dateForJudge.equals("1") && name.contains("book") && store.equals("A")){
//            flag = true;
//        }
//        return flag;
//    }
}
