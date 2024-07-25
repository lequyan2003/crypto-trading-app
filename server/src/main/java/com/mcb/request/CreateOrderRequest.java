package com.mcb.request;

import com.mcb.domain.OrderType;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String coinId;
    private double quantity;
    private OrderType orderType;
}
