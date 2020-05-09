package com.kodilla.good.patterns.challenges.allegro;



public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderService orderService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto order(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderTime())
                ;

        if(isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrderProduct(orderRequest.getUser(),orderRequest.getProduct(),orderRequest.getOrderTime());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}