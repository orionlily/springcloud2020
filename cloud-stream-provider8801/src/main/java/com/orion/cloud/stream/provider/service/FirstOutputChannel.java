package com.orion.cloud.stream.provider.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Administrator
 * @date 2020/10/11
 */
public interface FirstOutputChannel {
    /**
     * 定义通道的名称
     */
    String CHANNEL_NAME = "firstOut";

    /**
     * 定义为输入通道
     *
     * @return MessageChannel
     */
    @Output(CHANNEL_NAME)
    MessageChannel sendFirstMsg();
}
