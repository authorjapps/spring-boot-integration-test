package com.springboot.service;


import com.springboot.dbcache.CustomerCache;
import com.springboot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;

import static java.util.Optional.ofNullable;

@Component
public class DbPersistenceService {

    private static ConcurrentMap<String, Customer> customerCache = CustomerCache.INSTANCE.getInstance().map;

    public Customer getCustomerById(String customerId) {
        return ofNullable(customerCache.get(customerId)).orElse(null);
    }

    public void deleteCustomerById(String customerId) {
        Customer customerExisting = customerCache.get(customerId);
        if (customerExisting == null) {
            throw new RuntimeException(customerId + " does not exist. Hence could not delete.");
        }
        customerCache.remove(customerId);
    }

    public Customer createOrUpdateCustomer(String customerId, Customer customerNew) {

        Customer customerExisting = customerCache.get(customerId);

        Customer updatedCustomer;

        if (customerExisting != null) {
            updatedCustomer = updatedCustomer(customerId, customerNew, customerExisting);
            customerCache.put(customerId, updatedCustomer);
        } else {
            updatedCustomer = newCustomer(customerId, customerNew);
            customerCache.put(customerId, updatedCustomer);
        }

        return updatedCustomer;
    }

    private Customer newCustomer(String customerId, Customer customerNew) {
        Customer updatedCustomer;
        updatedCustomer = new Customer(
                customerId,
                customerNew.getName(),
                customerNew.getAge(),
                customerNew.getEmailId());
        return updatedCustomer;
    }

    private Customer updatedCustomer(String customerId, Customer customerNew, Customer customerExisting) {
        Customer updatedCustomer;
        updatedCustomer = new Customer(
                customerId,
                ofNullable(customerNew.getName()).orElse(customerExisting.getName()),
                ofNullable(customerNew.getAge()).orElse(customerExisting.getAge()),
                ofNullable(customerNew.getEmailId()).orElse(customerExisting.getEmailId())
        );
        return updatedCustomer;
    }

}
