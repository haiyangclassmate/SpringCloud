package com.zb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //往容器中添加一个RestTemplate
    //RestTemplate提供了多种便捷访问远程http访问的方法

    @Bean   //此注解相当于applicationContext.xml里面的bean
    @LoadBalanced   //此注解赋予restTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
