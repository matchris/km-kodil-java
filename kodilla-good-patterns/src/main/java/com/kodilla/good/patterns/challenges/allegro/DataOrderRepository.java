package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public class DataOrderRepository implements OrderRepository {
    @Override
    public boolean createOrderProduct(User user, Product product, LocalDateTime dateOfSale) {
        return false;
    }
}
