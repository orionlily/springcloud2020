package com.orion.cloud.stream.provider.controller;

import com.orion.cloud.stream.provider.service.FirstMsgSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020/10/11
 */
@RestController
public class FirstMsgSenderController {

    @Resource
    private FirstMsgSender firstMsgSender;

    @GetMapping("/firstSend")
    public void sendMsg(String msg){
        firstMsgSender.sendFirstMsg(msg);
    }
}
