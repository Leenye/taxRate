package com.homework.shoppingCart;

public class CartItem {
    private Product product;
    private int num;
    private double itemSaved;
    private double itemTax;

    public Product getProduct() {
        return product;
    }

    public int getNum() {
        return num;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CartItem(Product product,int num){
        this.product = product;
        this.num = num;
    }

    public double getItemSaved() {
        return Calculator.calculateTotalSaved(this);
    }

    public void setItemSaved(double itemSaved) {
        this.itemSaved = Calculator.calculateTotalSaved(this);
    }

    public double getItemTax() {
        return this.getProduct().getTax()*this.getNum();
    }

    public void setItemTax(double itemTax) {
        this.itemTax = itemTax;
    }

    public CartItem() {
    }
}
