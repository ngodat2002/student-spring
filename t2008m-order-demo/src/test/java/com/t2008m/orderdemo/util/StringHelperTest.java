package com.t2008m.orderdemo.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {
    @Test
    public void testSlug(){
        System.out.println(StringHelper.toSlug("Welcome to Vietnam"));
    }
}