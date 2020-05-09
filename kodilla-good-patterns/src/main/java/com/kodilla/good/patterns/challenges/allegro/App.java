package com.kodilla.good.patterns.challenges.allegro;

public class App {
    public static void main(String[] args) {

        ProductRequestRetriever productRequestRetriever = new ProductRequestRetriever();
        OrderRequest orderRequest = productRequestRetriever.retrieve();
        ProductOrderService productOrderService = new ProductOrderService(new MessageService(), new ProductOrder(), new DataOrderRepository());
        productOrderService.order(orderRequest);

    }
}
