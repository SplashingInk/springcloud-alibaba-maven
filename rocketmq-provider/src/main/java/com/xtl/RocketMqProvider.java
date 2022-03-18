package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;


/**
 * @ClassName RocketMqProvider
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/10 2:55
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class RocketMqProvider {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqProvider.class,args);
    }

}
