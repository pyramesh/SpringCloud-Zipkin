package com.example.zipkinservice4.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ramesh.Yaleru on 7/19/2019
 */
@RestController
public class ResourceController {


    @Autowired
    RestTemplate restTemplate;

    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    private static final Logger LOG = Logger.getLogger(ResourceController.class.getName());

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/zipkin4")
    public String zipkinService1() {
        LOG.info("Inside zipkinService 4..");
        return "Hi...";
    }
}
