package com.zb.service.impl;

import com.zb.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)  //定义消息的推送管道    注意这边的Source是Cloud-stream里面的，注意导包
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    public MessageChannel output;  //消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());  //MessageBuilder是Spring的integration.support.MessageBuilder
        System.out.println("*******serial: " + serial);
        return null;
    }
}
