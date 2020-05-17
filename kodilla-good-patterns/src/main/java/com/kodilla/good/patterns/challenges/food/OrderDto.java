package com.kodilla.good.patterns.challenges.food;

public class OrderDto {
    private ShopEnum shopEnum;

    public OrderDto(ShopEnum shopEnum) {
        this.shopEnum = shopEnum;
    }

    public ShopEnum getShopEnum() {
        return shopEnum;
    }
}
