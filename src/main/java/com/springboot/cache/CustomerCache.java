package com.springboot.cache;

import com.springboot.model.Customer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * CustomerCache class is used to store instruments and prices by Vendor
 */
public enum CustomerCache {

    INSTANCE(new ConcurrentHashMap<>());

    public ConcurrentMap<String, Customer> map = new ConcurrentHashMap<>();

    private ConcurrentMap<String, Customer> customerCache;

    private CustomerCache(ConcurrentMap<String, Customer> customerCache) {
        this.customerCache = customerCache;
    }

    public CustomerCache getInstance() {
        return INSTANCE;
    }

}
