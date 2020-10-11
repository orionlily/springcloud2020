package com.orion.cloud.stream.consumer.controller;

import com.orion.cloud.stream.consumer.service.FirstInputChannel;
import com.orion.cloud.stream.consumer.service.SecondInputChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2020/10/11
 */

@Component
@EnableBinding({FirstInputChannel.class, SecondInputChannel.class})
public class ConsumersgController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(FirstInputChannel.CHANNEL_NAME)
    public void receiveFirstMsg(Message<String> message){
        System.out.println("receive first msg ="+ message.getPayload()+"---"+serverPort);
    }

    @StreamListener(SecondInputChannel.CHANNEL_NAME)
    public void receiveSecondMsg(Message<String> message){
        System.out.println("receive second msg ="+ message.getPayload()+"---"+serverPort);
    }
}
