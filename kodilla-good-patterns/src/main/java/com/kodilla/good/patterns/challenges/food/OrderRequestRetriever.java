package com.kodilla.good.patterns.challenges.food;


public class OrderRequestRetriever {
    private ShopEnum shopTypeEnum;

    public OrderRequest retrieve() {
        Product product = new Product("Brown seaweed", 140.50);
        Double quantity = 5.0;
        shopTypeEnum = ShopEnum.GLUTEN_FREE_SHOP;

        return new OrderRequest(product, quantity, shopTypeEnum);
    }
}