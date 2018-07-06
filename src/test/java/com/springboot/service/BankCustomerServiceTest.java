package com.springboot.service;

import com.springboot.model.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankCustomerServiceTest {

    private BankCustomerService bankCustomerService;

    @Before
    public void setUp() {
        bankCustomerService = new BankCustomerService(new DbPersistenceService());
    }

    @Test
    public void testUpdateCustomer() {
        Customer updatedCustomer = bankCustomerService.updaeCustomer("dummy-cust-001",
                new Customer(null, "aName", 100, "anemail@email.com"));

        assertThat(updatedCustomer.getName(), is("aName"));
        assertThat(updatedCustomer.getAge(), is(100));
        assertThat(updatedCustomer.getEmailId(), is("anemail@email.com"));
    }
}