package com.kodilla.good.patterns.challenges.food;


import java.util.ArrayList;
import java.util.Optional;

public class ExtraFoodShop implements Supplier {
    private ArrayList<Product> productsList;

    public ExtraFoodShop() {
        productsList = new ArrayList<>();
        productsList.add(new Product("Green petals", 40));
        productsList.add(new Product("Jerusalem artichokes", 100));

    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        Optional<Product> productOptional = productsList.stream()
                .filter(productInList -> productInList.getProductName().equals(orderRequest.getProduct().getProductName()))
                .findAny();

        if (productOptional.isPresent()) {
            System.out.println("Thank you for shopping in our ExtraFood Shop");
            return true;
        }
        return false;
    }
}