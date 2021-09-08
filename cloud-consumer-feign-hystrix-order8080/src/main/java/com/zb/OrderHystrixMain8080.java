package com.zb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  //激活feign
@EnableHystrix  //激活hystrix服务
public class OrderHystrixMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8080.class,args);
    }
}
