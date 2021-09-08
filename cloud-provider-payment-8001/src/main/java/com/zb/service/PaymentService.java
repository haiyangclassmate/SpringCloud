package com.zb.service;

import com.zb.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    Integer add(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
