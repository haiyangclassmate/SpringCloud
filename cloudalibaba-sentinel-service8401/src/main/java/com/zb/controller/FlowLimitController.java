package com.zb.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        System.out.println("正在处理"+new Date());
        return "---testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "---testB";
    }

    @GetMapping("/testD")
    public String testD() {
        /*log.info("测试时间-------"+new Date());
        try { TimeUnit.SECONDS.sleep(1); }catch (Exception e){ e.printStackTrace();}
        log.info("testD 测试RT");*/
        log.info("testD 异常比例");
        int age = 10/0;
        return "----testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 异常数");
        //int age = 10/0;
        return "----testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(name = "p1",required = false) String p1,
                             @RequestParam(name = "p2",required = false) String p2){
        return "---获取热词正常---";
    }
    public String dealHandler_testHotKey(String p1, String p2, BlockException e){
        System.out.println(e);
        return "---触发保护机制---";
    }


}
