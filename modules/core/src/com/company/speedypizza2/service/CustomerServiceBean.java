package com.company.speedypizza2.service;

import com.company.speedypizza2.entity.Customer;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FluentLoader;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service(CustomerService.NAME)
public class CustomerServiceBean implements CustomerService {

    @Inject
    private DataManager dataManager;

    @Override
    public Customer getCustomerByUser(User user) {
        FluentLoader.ByQuery<Customer, UUID> query = dataManager.load(Customer.class)
                .view("customer-view")
                .query("select c from speedypizza2_Customer c where c.user = :user");
        Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        query.setParameters(params);

        return query.one();
    }
}