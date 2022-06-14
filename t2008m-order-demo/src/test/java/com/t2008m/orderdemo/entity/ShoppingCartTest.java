package com.t2008m.orderdemo.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    @Test
    public void demoBuilder(){
        CartItem item = new CartItem();
        item.setId(new CartItemId());
        item.setProductImage("");
        item.setUnitPrice(new BigDecimal(0));
        item.setQuantity(1);
        System.out.println(item.toString());
        CartItem item2 = CartItem.builder()
                .id(new CartItemId())
                .productImage("")
                .build();
        System.out.println(item2.toString());
    }
}