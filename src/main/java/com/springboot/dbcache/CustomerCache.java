package com.springboot.dbcache;

import com.springboot.model.Customer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * CustomerCache class is used to store customers by their id as key
 */
public enum CustomerCache {

    INSTANCE(new ConcurrentHashMap<>());

    public static ConcurrentMap<String, Customer> map = new ConcurrentHashMap<>();

    private ConcurrentMap<String, Customer> customerCache;

    private CustomerCache(ConcurrentMap<String, Customer> customerCache) {
        this.customerCache = customerCache;
    }

    public CustomerCache getInstance() {
        return INSTANCE;
    }

}
