package com.kodilla.good.patterns.challenges.allegro;

public class MessageService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Your order is completed");

    }
}
