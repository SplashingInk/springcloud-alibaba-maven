package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName NacosConsumer
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 15:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumer {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer.class,args);
    }
}
