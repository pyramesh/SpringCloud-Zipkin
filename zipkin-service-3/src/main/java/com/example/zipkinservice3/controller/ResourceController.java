package com.example.zipkinservice3.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ramesh.Yaleru on 7/19/2019
 */
@RestController
public class ResourceController {

    private static final Logger LOG = Logger.getLogger(ResourceController.class.getName());
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    @GetMapping(value = "/zipkin3")
    public String zipkinService1() {
        LOG.info("Inside zipkinService 3..");
        String response = (String) restTemplate.exchange("http://localhost:8084/zipkin4", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();
        return "Hi...";
    }
}
