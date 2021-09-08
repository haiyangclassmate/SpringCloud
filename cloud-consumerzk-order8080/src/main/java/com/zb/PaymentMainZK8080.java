package com.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //开启zookeeper注册中心配置
public class PaymentMainZK8080 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainZK8080.class,args);
    }
}
