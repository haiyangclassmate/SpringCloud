package com.zb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  // 自动刷新
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")	//spring的@Value注解
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){

        return "serverPort"+serverPort+"configInfo"+configInfo;
    }
}
