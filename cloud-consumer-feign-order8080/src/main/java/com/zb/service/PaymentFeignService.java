package com.zb.service;

import com.zb.entity.CommonResult;
import com.zb.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Feign封装了Ribbon和RestTemplate，实现负载均衡和发送请求
@Component        //将此类注册进spring容器
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")    //作为feign的接口，找CLOUD-PAYMENT-SERVICE服务
public interface PaymentFeignService {
    /*
        接口加@GetMapping指定值，相当于restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
        在接口中指明请求的8001/8002的服务路径，因为在controller方法里面没有指明路径，只是调用了其中的方法，加上上面的@FeignClient,
        就可以确定哪个服务的哪个url
     */
    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();

}
