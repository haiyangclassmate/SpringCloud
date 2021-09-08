package com.zb.dao;

import com.zb.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    Integer insert(Order order); //新增订单

    Integer update(@Param("userId") Long userId,@Param("status") Integer status);   //修改状态
}
