package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public class ProductRequestRetriever {  //Tworzymy klasę do zwracania zamówień
    public OrderRequest retrieve() {
        User user = new User("John","Kowalski","user2344","john1993r@gmail.com");
        Product product = new Product("Some goods",344.22);
        LocalDateTime localDate = LocalDateTime.of(2020,01,10,22,15);

        return new OrderRequest(user,product,localDate);
    }


}
