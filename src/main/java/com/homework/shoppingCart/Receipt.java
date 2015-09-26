package com.homework.shoppingCart;

public class Receipt {
    private Cart cart;
    public void printOutReceipt(Cart cart){
        System.out.println(cart.getDate());
        System.out.println(cart.getStore());
        for (CartItem i : cart.getCartItemList()) {
            System.out.println(i.getNum() + i.getProduct().getName() + ": " + i.getItemCost());
            System.out.println("  --discout is " + i.getItemSaved());
            System.out.println("  --tax is " + i.getItemTax());
        }
        System.out.format("total sales Taxes: %.2f%n", cart.getTotalTaxes());
        System.out.format("Total costs: %.2f%n", cart.getTotalCosts());
    }
}
