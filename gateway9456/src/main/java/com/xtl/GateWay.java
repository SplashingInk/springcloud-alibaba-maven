package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName GateWay
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 17:21
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GateWay {
    public static void main(String[] args) {
        SpringApplication.run(GateWay.class,args);
    }
}
