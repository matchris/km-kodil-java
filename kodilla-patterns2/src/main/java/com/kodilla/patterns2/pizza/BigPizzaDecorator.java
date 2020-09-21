package com.kodilla.patterns2.pizza;

import java.math.BigDecimal;

public class BigPizzaDecorator extends PizzaOrderDecorator {
    public BigPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(20));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " rozmiar XL";
    }
}
