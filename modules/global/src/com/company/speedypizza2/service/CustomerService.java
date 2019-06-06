package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Customer;
import com.haulmont.cuba.security.entity.User;

public interface CustomerService {
    String NAME = "speedypizza2_CustomerService";

    Customer getCustomerByUser(User user);
}