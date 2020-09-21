package com.kodilla.patterns2.pizza;

import java.math.BigDecimal;

public class PizzaOrderDecorator implements PizzaOrder {

    private final PizzaOrder pizzaOrder;

    public PizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}
