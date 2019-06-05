package com.company.speedypizza2.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Customer;

@UiController("speedypizza2_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}