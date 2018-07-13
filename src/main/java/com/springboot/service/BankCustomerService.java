package com.springboot.service;

import com.springboot.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCustomerService {
    private static Logger LOGGER = LogManager.getLogger(BankCustomerService.class);

    private final DbPersistenceService persistenceService;

    @Autowired
    public BankCustomerService(DbPersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    public Customer updaeCustomer(String customerId, Customer customer) {
        return persistenceService.createOrUpdateCustomer(customerId, customer);
    }

    public Customer findCustomer(String customerId) {
        return persistenceService.getCustomerById(customerId);
    }

    public void deleteCustomer(String customerId) {
        persistenceService.deleteCustomerById(customerId);
    }
}
