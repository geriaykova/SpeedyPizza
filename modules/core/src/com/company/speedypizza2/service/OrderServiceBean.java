package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Dish;
import com.company.speedypizza2.entity.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    //TODO: как да покажа само order-ите на дадения customer?
 /*   private List<Order> getOrders(EntityManager em){
        TypedQuery<Order> query = em.createQuery(
                //distinct - гледа типовете на consumables, не броя им
                "select distinct c from petclinic_Visit v join v.consumables c " +
                        "where @between(c.createTs, now-7, now+1, day)"
                "select distinct * from speedypizza_Order o join o.customer c" +
                        "where c = c",
                Order.class);
        query.setViewName(View.LOCAL);

        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public List<Consumable> getUsedConsumables() {
        return persistence.callInTransaction(this::getConsumables);
    }
*/

}