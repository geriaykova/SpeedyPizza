package com.company.speedypizza2.web.screens.customer;

import com.company.speedypizza2.entity.Order;
import com.company.speedypizza2.service.CustomerService;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Customer;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;

@UiController("speedypizza2_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
    @Inject
    private UserSession userSession;
    @Inject
    private CustomerService customerService;

    @Subscribe
    private void onInitEntity(InitEntityEvent<Customer> event) {
        event.getEntity().setUser(userSession.getUser());
        event.getEntity().setName(userSession.getUser().getName());
    }





}