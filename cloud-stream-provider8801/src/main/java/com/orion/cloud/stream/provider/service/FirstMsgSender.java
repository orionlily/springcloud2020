package com.orion.cloud.stream.provider.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020/10/11
 */
@EnableBinding(FirstOutputChannel.class)
public class FirstMsgSender{

    @Resource
    @Qualifier(FirstOutputChannel.CHANNEL_NAME)
    private MessageChannel messageChannel;

    public void sendFirstMsg(String msg) {
        System.out.println("send first msg = "+ msg);
        messageChannel.send(MessageBuilder.withPayload(msg).build());
    }
}
