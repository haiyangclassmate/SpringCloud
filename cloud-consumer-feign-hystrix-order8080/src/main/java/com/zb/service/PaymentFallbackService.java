package com.zb.service;

import org.springframework.stereotype.Component;
//统一为接口里面的方法进行异常处理
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String PaymentInfo_ok(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_OK----";
    }

    @Override
    public String PaymentInfo_timeOut(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_TimeOut----";
    }
}
