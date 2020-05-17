package com.kodilla.good.patterns.challenges.food;

public class GlutenFreeShop implements Supplier {

    @Override
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Thank You for your order in GlutenFree Shop.");
        return true;
    }
}
