package com.zb.controller;

import com.zb.entity.CommonResult;
import com.zb.entity.Order;
import com.zb.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/order/insert")
    public CommonResult insert(Order order){
        orderService.insert(order);
        return new CommonResult(200,"订单创建成功！");
    }

}
