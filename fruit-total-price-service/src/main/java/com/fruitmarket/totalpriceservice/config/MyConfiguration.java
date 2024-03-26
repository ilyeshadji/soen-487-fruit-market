package com.fruitmarket.totalpriceservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyConfiguration {

    @Autowired
    private Environment env;

    public String getPort() {
        return env.getProperty("server.port");
    }
}
