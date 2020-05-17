package com.kodilla.good.patterns.challenges.food;

public class FoodOrderService implements OrderService {
    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retrieve();

    @Override
    public boolean order(Product product, Double quantity, ShopEnum shopTypeEnum) {
        System.out.println("An order: " + product.getProductName() + " has been completed at a total price of: "
                + orderRequest.getQuantity() * product.getProductPrice());
        return false;
    }
}
