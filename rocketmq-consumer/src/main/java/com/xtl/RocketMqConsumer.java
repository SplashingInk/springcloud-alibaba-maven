package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @ClassName RocketMqProvider
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/10 2:55
 */
@SpringBootApplication
@EnableBinding({Sink.class})
public class RocketMqConsumer {


    public static void main(String[] args) {
        SpringApplication.run(RocketMqConsumer.class,args);
    }

    @StreamListener(value = Sink.INPUT)
    public void receiveInput(String msg){
        System.out.println("receiver message:"+msg);
    }
}
