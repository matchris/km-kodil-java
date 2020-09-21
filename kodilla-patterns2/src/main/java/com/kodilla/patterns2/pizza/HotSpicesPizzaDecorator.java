package com.kodilla.patterns2.pizza;

import java.math.BigDecimal;

public class HotSpicesPizzaDecorator extends PizzaOrderDecorator {
    public HotSpicesPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ostre przyprawy";
    }
}
