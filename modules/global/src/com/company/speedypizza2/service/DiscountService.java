package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Order;

public interface DiscountService {
    String NAME = "speedypizza2_DiscountService";

    void checkForDiscount(Order order);
    void make5PercentDiscount(Order order);
    void make10PercentDiscount(Order order);
}