package com.zb.controller;

import com.zb.entity.CommonResult;
import com.zb.entity.Payment;
import com.zb.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        Integer result = paymentService.add(payment);
        log.info("****插入结果"+result);
        if(result>0){
            return new CommonResult(200,"新增数据成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"新增数据失败",null);
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功,serverport:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有数据，查询id"+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String PaymentLb(){
        return serverPort;
    }
}
