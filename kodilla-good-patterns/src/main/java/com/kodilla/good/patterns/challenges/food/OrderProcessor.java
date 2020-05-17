package com.kodilla.good.patterns.challenges.food;

public class OrderProcessor {
    private OrderService orderService;

    public OrderProcessor(OrderService orderService) {
        this.orderService = orderService;
    }

    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retrieve();

    void processOrder(OrderDto orderDto) {

        switch (orderDto.getShopEnum()) {
            case EXTRA_FOOD_SHOP:
                ExtraFoodShop extraFoodShop = new ExtraFoodShop();
                extraFoodShop.process(orderRequest);
                orderService.order(orderRequest.getProduct(), orderRequest.getQuantity(), orderDto.getShopEnum());
                break;

            case GLUTEN_FREE_SHOP:
                GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
                glutenFreeShop.process(orderRequest);
                orderService.order(orderRequest.getProduct(), orderRequest.getQuantity(), orderDto.getShopEnum());
                break;

            default:

            case HEALTHY_SHOP:
                HealthyShop healthyShop = new HealthyShop();
                healthyShop.process(orderRequest);
                orderService.order(orderRequest.getProduct(), orderRequest.getQuantity(), orderDto.getShopEnum());
                break;

        }

    }
}