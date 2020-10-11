package com.orion.cloud.stream.provider.controller;

import com.orion.cloud.stream.provider.service.SecondMsgSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020/10/11
 */
@RestController
public class SecondMsgSenderController {

    @Resource
    private SecondMsgSender secondMsgSender;

    @GetMapping("/secondSend")
    public void sendMsg(String msg){
        secondMsgSender.sendSecondMsg(msg);
    }
}
