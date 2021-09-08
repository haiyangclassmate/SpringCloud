package com.zb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;  // 订单集合
    // 当没有数据传递来的时候,调用此构造
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}