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
@EnableBinding(SecondOutputChannel.class)
public class SecondMsgSender {

    @Resource
    @Qualifier(SecondOutputChannel.CHANNEL_NAME)
    private MessageChannel messageChannel;

    public void sendSecondMsg(String msg) {
        System.out.println("send second msg = "+ msg);
        messageChannel.send(MessageBuilder.withPayload(msg).build());
    }
}
