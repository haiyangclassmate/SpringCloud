package com.zb.service;


import com.zb.entity.CommonResult;
import com.zb.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    void insert(Order order); //新增订单

}
