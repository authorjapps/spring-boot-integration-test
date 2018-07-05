package com.springboot.service;


import com.springboot.cache.CustomerCache;
import com.springboot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DbPersistenceService {

    public Customer createOrUpdateCustomer(String customerId, Customer customer) {

        Customer updadatedCustomer = new Customer(customerId, customer.getName(), customer.getAge(), customer.getEmailId());

        CustomerCache.INSTANCE.map.putIfAbsent(customerId, updadatedCustomer);

        return updadatedCustomer;
    }

    public Customer getCustomerById(String customerId) {

        return Optional.ofNullable(CustomerCache.INSTANCE.map.get(customerId)).orElse(null);

    }
}
