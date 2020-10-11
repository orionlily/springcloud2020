package com.orion.cloud.stream.provider.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Administrator
 * @date 2020/10/11
 */
public interface SecondOutputChannel {
    /**
     * 定义通道的名称
     */
    String CHANNEL_NAME = "secondOut";

    /**
     * 定义为输入通道
     *
     * @return MessageChannel
     */
    @Output(CHANNEL_NAME)
    MessageChannel sendSecondMsg();
}
