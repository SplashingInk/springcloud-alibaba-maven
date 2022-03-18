package com.xtl.controller;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProviderController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/10 16:55
 */
@RestController
public class ProviderController {

    @Resource
    private MessageChannel output;

    @GetMapping("/produce/{msg}")
    public String produceMsg(@PathVariable("msg") String msg) {
        Map<String, Object> headers = new HashMap<>(16);
        headers.put(MessageConst.PROPERTY_TAGS, "hello");
        headers.put(MessageConst.PROPERTY_KEYS,"hello");
        Message<String> message = MessageBuilder.createMessage(msg, new MessageHeaders(headers));
        output.send(message);
        System.out.println("发送了消息 "+message);
        return "success";
    }

}
