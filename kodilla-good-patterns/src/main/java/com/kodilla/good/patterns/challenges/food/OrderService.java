package com.kodilla.good.patterns.challenges.food;

public interface OrderService {
    boolean order(Product product, Double quantity, ShopEnum shopTypeEnum);
}
