package com.homework.shoppingCart;

import com.homework.shoppingCart.Product;

import java.util.Map;

/**
 * Created by twer on 9/1/15.
 */
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

    public CartItem(Product goods,int num){
        this.product = goods;
        this.num = num;
    }

    public CartItem() {
    }
}
