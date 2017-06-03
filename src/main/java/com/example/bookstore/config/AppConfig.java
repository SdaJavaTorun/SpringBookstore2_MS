package com.example.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Created by RENT on 2017-06-03.
 */

@Configuration
public class AppConfig {


    @Bean
    public RestOperations restOperations(){
        return new RestTemplate();
    }


}
