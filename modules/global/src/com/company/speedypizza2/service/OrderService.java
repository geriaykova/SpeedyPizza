package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Order;

import java.math.BigDecimal;

public interface OrderService {
    String NAME = "speedypizza2_OrderService";

    BigDecimal calculateAmount(Order order);
}