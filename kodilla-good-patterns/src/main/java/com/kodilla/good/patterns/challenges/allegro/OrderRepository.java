package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public interface OrderRepository {
    boolean createOrderProduct(User user, Product product, LocalDateTime dateOfSale);
}
