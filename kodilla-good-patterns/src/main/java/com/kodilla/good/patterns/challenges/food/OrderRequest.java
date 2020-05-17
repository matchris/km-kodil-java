package com.kodilla.good.patterns.challenges.food;

public class OrderRequest {
    private Product product;
    private double quantity;
    ShopEnum shopEnum;

    public OrderRequest(Product product, double quantity, ShopEnum shopEnum) {
        this.product = product;
        this.quantity = quantity;
        this.shopEnum = shopEnum;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public ShopEnum getShopTypeEnum() {
        return shopEnum;
    }
}