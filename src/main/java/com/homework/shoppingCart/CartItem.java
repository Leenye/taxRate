package com.homework.shoppingCart;

import com.homework.shoppingCart.Product;

import java.util.Map;

public class CartItem {
    private Product product;
    private int num;

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

    public CartItem() {
    }
}
