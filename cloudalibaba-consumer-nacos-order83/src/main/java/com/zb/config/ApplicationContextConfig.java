package com.zb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //配置类
public class ApplicationContextConfig {

    @Bean  //注册进Spring容器
    @LoadBalanced  //RestTemplate只支持服务的调用，使用此注解赋予RestTmepalte负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
