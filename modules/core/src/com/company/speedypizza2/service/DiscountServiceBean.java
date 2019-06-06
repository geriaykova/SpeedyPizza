package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Order;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;

@Service(DiscountService.NAME)
public class DiscountServiceBean implements DiscountService {


    @Inject
    private OrderService orderService;

    @Override
    public void checkForDiscount(Order order) {
        System.out.println("doing checkForDiscount");
        if(order.getDishes().size() > 3 && order.getDishes().size() < 11){
            make5PercentDiscount(order);
        }
        else if(order.getDishes().size() > 10){
            make10PercentDiscount(order);
        }
//        orderService.calculateAmount(order);
    }

    @Override
    public void make5PercentDiscount(Order order) {
        System.out.println("doing make5PercentDiscount");
        order.setDiscount(order.getDiscount().add(BigDecimal.valueOf(5)));
    }

    @Override
    public void make10PercentDiscount(Order order) {
        System.out.println("doing make10PercentDiscount");
        order.setDiscount(order.getDiscount().add(BigDecimal.valueOf(10)));
    }
}