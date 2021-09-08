package com.zb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {

    private static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/consul")
    public String getPaymentConsul(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}
