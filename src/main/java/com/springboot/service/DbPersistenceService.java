package com.springboot.service;


import com.springboot.cache.CustomerCache;
import com.springboot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import static java.util.Optional.ofNullable;

@Component
public class DbPersistenceService {

    public Customer createOrUpdateCustomer(String customerId, Customer customerNew) {

        ConcurrentMap<String, Customer> customerCache = CustomerCache.INSTANCE.getInstance().map;

        Customer customerExisting = customerCache.get(customerId);

        Customer updatedCustomer;

        if (customerExisting != null) {
            updatedCustomer = new Customer(
                    customerId,
                    ofNullable(customerNew.getName()).orElse(customerExisting.getName()),
                    ofNullable(customerNew.getAge()).orElse(customerExisting.getAge()),
                    ofNullable(customerNew.getEmailId()).orElse(customerExisting.getEmailId())
            );
            customerCache.put(customerId, updatedCustomer);

        } else {
            updatedCustomer = new Customer(
                    customerId,
                    customerNew.getName(),
                    customerNew.getAge(),
                    customerNew.getEmailId());
            customerCache.put(customerId, updatedCustomer);

        }

        return updatedCustomer;
    }

    public Customer getCustomerById(String customerId) {

        return ofNullable(CustomerCache.INSTANCE.map.get(customerId)).orElse(null);

    }
}
