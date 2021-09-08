package com.zb.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zb.entity.CommonResult;
import com.zb.entity.Payment;
import com.zb.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource") //根据资源名称byResource限流
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    // 在这里指定了自定应的备选方案,当触发 sentinel 流控规则触发
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    /*根据如下配置，一旦此方法配置出问题，就会调用CustomerBlockHandler类当中的handlerException1方法处理限流，
    实现自定义的处理方法又和业务代码解耦，实现全局统—的处理方法*/
    @SentinelResource(value = "byUrl",blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException1")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial001"));
    }
}
