package com.kodilla.patterns.builder.pizza;

import org.junit.Assert;
import org.junit.Test;

public class PizzaTestSuite {
    @Test
    public void testPizzaNew() {
        //Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .bottom("Thin")
                .sauce("Spicy")
                .ingredient("Cheese")
                .ingredient("Onion")
                .ingredient("Mushrooms")
                .ingredient("Ham")
                .ingredient("Pepper")
                .build();

        System.out.println(pizza);
        //When
        int howManyIngredients = pizza.getIngredients().size();
        //Then
        Assert.assertEquals(5,howManyIngredients);
        Assert.assertEquals(true,pizza.getIngredients().contains("Cheese"));
        Assert.assertEquals(true,pizza.getSauce().equals("Spicy"));
    }
}
