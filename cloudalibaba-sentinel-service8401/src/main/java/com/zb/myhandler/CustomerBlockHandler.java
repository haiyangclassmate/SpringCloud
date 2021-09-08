package com.zb.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zb.entity.CommonResult;

public class CustomerBlockHandler {
    //注意这里方法一定是静态的
    public static CommonResult handlerException1(BlockException e){
        return new CommonResult(444,"根据自定义类CustomerBlockHanler处理限流信息");
    }
}
