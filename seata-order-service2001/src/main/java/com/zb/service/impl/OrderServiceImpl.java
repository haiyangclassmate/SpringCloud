package com.zb.service.impl;

import com.zb.dao.OrderDao;
import com.zb.entity.CommonResult;
import com.zb.entity.Order;
import com.zb.service.AccountService;
import com.zb.service.OrderService;
import com.zb.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "aaa",rollbackFor = Exception.class)
    public void insert(Order order) {
        //  1.新建订单
        log.info("-------> 开始新建订单");
        orderDao.insert(order);

        // 2.扣减库存
        log.info("-------> 订单微服务开始调用库存，做扣减count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------> 订单微服务开始调用库存，做扣减完成");

        //3. 扣减账号余额
        log.info("-------> 订单微服务开始调用账号，做扣减money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------> 订单微服务开始调用账号，做扣减完成");

        //4. 修改订单状态，1代表已完成
        log.info("-------> 修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("-------> 修改订单状态完成");

        log.info("-------> 新建订单完成");
    }
}
