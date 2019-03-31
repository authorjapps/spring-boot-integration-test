package com.springboot.controller;

import com.springboot.model.Customer;
import com.springboot.service.BankCustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerController {

    private static Logger LOGGER = LogManager.getLogger(CustomerController.class);

    @Autowired
    private BankCustomerService bankCustomerService;

    @ResponseBody
    @PutMapping(value = "/api/abc-bank/customers/{customerId}")
    public ResponseEntity putCustomerById(@PathVariable String customerId, @RequestBody Customer customer) {

        LOGGER.info("Updating customer:{}", customerId);

        Customer updatedCustomer = bankCustomerService.updaeCustomer(customerId, customer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/api/abc-bank/customers/{customerId}")
    public ResponseEntity getCustomerById(@PathVariable("customerId") String customerId) {

        LOGGER.info("Fetching customer:{}", customerId);

        Customer customer = bankCustomerService.findCustomer(customerId);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "/api/abc-bank/customers/{customerId}")
    public ResponseEntity deleteCustomerById(@PathVariable("customerId") String customerId) {

        LOGGER.info("Fetching customer:{}", customerId);

        bankCustomerService.deleteCustomer(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/api/v1/issues/arunv", consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity handleRequest(@RequestParam Map<String, String> params, @RequestHeader HttpHeaders httpHeaders) {

        LOGGER.info("Request params received - " + params);
        LOGGER.info("Request httpHeaders received - " + httpHeaders);

        return new ResponseEntity<>("{\"working\": \"Well\"}", HttpStatus.CREATED);
    }

    @PostMapping(value = "/api/v1/issues/customer", consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity handleRequestCustomer( @RequestParam MultiValueMap paramMap ) {

        LOGGER.info("Request params received - " + paramMap);

        return new ResponseEntity<>("{\"working\": \"Well\"}", HttpStatus.CREATED);
    }

}