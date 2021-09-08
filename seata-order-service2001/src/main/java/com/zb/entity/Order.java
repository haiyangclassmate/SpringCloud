package com.zb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;

    /*用户id*/
    private Long userId;

    /*产品id*/
    private Long productId;

    /*数量*/
    private Integer count;

    /*金额*/
    private BigDecimal money;

    /*订单状态：0：创建中; 1：已完结*/
    private Integer status;
}
