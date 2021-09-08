package com.zb.dao;

import com.zb.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    Integer add(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
