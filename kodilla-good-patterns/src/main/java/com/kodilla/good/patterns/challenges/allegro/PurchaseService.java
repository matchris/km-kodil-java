package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;

public interface PurchaseService {
    boolean purchase(User user, LocalDate purchaseDay, String product);
}
