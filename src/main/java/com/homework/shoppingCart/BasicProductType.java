package com.homework.shoppingCart;

import java.lang.reflect.ParameterizedType;

/**
 * Created by twer on 9/10/15.
 */
public class BasicProductType {

    public boolean isImported(String name){
        boolean imoportedFlag = false;

        if (name.contains("imported")){
            imoportedFlag = true;
        }
        return imoportedFlag;
    }

    public boolean isExempt(String name){
        boolean ExemptFlag = false;
        if (name.contains("book") || name.contains("chocolate") || name.contains("pills")){
            ExemptFlag = true;
        }
        return ExemptFlag;
    }
}
