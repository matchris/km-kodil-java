package com.kodilla.patterns2.pizza;

import java.math.BigDecimal;

public class SeaFoodPizzaDecorator extends PizzaOrderDecorator {
    public SeaFoodPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(15));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + owoce morza";
    }
}
