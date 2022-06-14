package com.t2008m.orderdemo.seeder;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationSeederTest {

    @Test
    public void testFaker(){
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            System.out.println(faker.address().country());
        }
    }
}