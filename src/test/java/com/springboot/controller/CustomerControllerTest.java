package com.springboot.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {
        // Scenarios covered in the integration tests
        // See >> integrationtests.get.VerifyGetFeature.java

    }

    @Test
    public void testPut() {
        // Scenarios covered in the integration tests
        // See >> integrationtests.put.VerifyPutFeature.java
    }
}