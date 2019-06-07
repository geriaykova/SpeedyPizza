package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Dish;
import com.company.speedypizza2.entity.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    String NAME = "speedypizza2_OrderService";

    BigDecimal calculateAmount(Order order);
    BigDecimal calculateDiscount(Order order);
//    void checkForDiscount(Order order);
//    void make5PercentDiscount(Order order);
//    void make10PercentDiscount(Order order);
}