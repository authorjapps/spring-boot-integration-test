package com.springboot;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {
    private static Logger LOGGER = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Spring Boot Demo App...");
        start();
    }

    public static void start() {
        SpringApplication.run(Application.class);
    }

}

