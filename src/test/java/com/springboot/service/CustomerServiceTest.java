package com.springboot.service;

import com.springboot.model.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerServiceTest {

    private CustomerService customerService;

    @Before
    public void setUp() {
        customerService = new CustomerService(new DbPersistenceService());
    }

    @Test
    public void testUpdateCustomer() {
        Customer updatedCustomer = customerService.updaeCustomer("dummy-cust-001",
                new Customer(null, "aName", 100, "anemail@email.com"));

        assertThat(updatedCustomer.getName(), is("aName"));
        assertThat(updatedCustomer.getAge(), is(100));
        assertThat(updatedCustomer.getEmailId(), is("anemail@email.com"));
    }
}