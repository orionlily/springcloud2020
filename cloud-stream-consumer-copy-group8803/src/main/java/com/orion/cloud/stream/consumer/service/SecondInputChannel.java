package com.orion.cloud.stream.consumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author Administrator
 * @date 2020/10/11
 */
public interface SecondInputChannel {
    /**
     * 定义通道的名称
     */
    String CHANNEL_NAME = "secondIn";

    /**
     * 定义为输入通道
     *
     * @return MessageChannel
     */
    @Input(CHANNEL_NAME)
    MessageChannel sendSecondMsg();
}
