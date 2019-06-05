package com.company.speedypizza2.web.screens.customer;

import com.company.speedypizza2.entity.Order;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Customer;

import javax.inject.Inject;

@UiController("speedypizza2_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
    @Inject
    private CollectionContainer<Order> ordersDc;
    @Inject
    private CollectionLoader<Order> orderDl;
    @Inject
    private InstanceContainer<Customer> customerDc;
    @Inject
    private InstanceLoader<Customer> customerDl;

//    @Subscribe
//    private void onInitEntity(InitEntityEvent<Customer> event) {
////        while(ordersDc.getItems().iterator().hasNext()){
////            if()
////        }
//        customerDl.load();
//        for(Order order : ordersDc.getItems()){
//            if(order.getCustomer().equals(getEditedEntity())){
//                orderDl.load();
//            }
//        }
//    }
}