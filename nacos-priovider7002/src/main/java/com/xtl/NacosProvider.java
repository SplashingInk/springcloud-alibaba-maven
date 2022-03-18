package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName NacosProvider
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 15:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvider.class,args);
    }
}
