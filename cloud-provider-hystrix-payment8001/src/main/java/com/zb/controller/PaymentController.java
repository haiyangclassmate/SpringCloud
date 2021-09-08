package com.zb.controller;

import com.zb.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")  //spring的端口
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentService.PaymentInfo_ok(id);
        log.info("****************result:"+result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeOut/{id}")
    public String PaymentInfo_timeOut(@PathVariable("id") Integer id){
        String result = paymentService.PaymentInfo_timeOut(id);
        log.info("****************result:"+result);
        return result;
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("******result：" + result);
        return result;
    }
}
