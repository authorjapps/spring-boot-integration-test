package com.springboot.controller;

import com.springboot.model.Customer;
import com.springboot.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private static Logger LOGGER = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @PutMapping(value = "/api/abc-bank/customers/{customerId}")
    public ResponseEntity postVendorFeed(@PathVariable String customerId, @RequestBody Customer customer) {

        LOGGER.info("Updating customer:{}", customerId);

        Customer updatedCustomer = customerService.updaeCustomer(customerId, customer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/api/abc-bank/customers/{customerId}")
    public ResponseEntity getInstrumentsByVendor(@PathVariable("customerId") String customerId) {

        LOGGER.info("Fetching customer:{}", customerId);

        Customer customer = customerService.findCustomer(customerId);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}