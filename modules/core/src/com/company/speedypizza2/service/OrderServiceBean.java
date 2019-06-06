package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Dish;
import com.company.speedypizza2.entity.Order;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {



    @Override
    public BigDecimal calculateAmount(Order order) {
        BigDecimal amount = BigDecimal.valueOf(0);
        if(order.getDishes() != null ){
            for(Dish d : order.getDishes()){
                amount = amount.add(d.getPrice());
            }
        }
        if(!order.getDiscount().equals(BigDecimal.valueOf(0))){
            BigDecimal discount = order.getDiscount().divide(BigDecimal.valueOf(100));
            amount = amount.subtract(amount.multiply(discount));
        }
        return amount;
    }

//    @Override
//    public void checkForDiscount(Order order){
//        if(order.getDishes().size() > 3 && order.getDishes().size() < 11){
//            make5PercentDiscount(order);
//        }
//        else if(order.getDishes().size() > 10){
//            make10PercentDiscount(order);
//        }
//    }
//
//
//    @Override
//    public void make5PercentDiscount(Order order){
//        order.setDiscount(order.getDiscount().add(BigDecimal.valueOf(5)));
//    }
//
//    @Override
//    public void make10PercentDiscount(Order order) {
//        order.setDiscount(order.getDiscount().add(BigDecimal.valueOf(10)));
//    }





}