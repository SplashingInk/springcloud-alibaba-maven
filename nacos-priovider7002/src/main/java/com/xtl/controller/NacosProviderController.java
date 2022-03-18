package com.xtl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName NacosProviderController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 15:10
 */
@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String appName;

   @Resource
   private ConfigurableApplicationContext context;


    @GetMapping("/getServerPort")
    public String getServerPort(){
        return "服务提供者的端口号："+serverPort;
    }

    @GetMapping("/getAppName")
    public String getAppName(){
        return "服务名称是："+appName;
    }

    @GetMapping("/getCustomerInfo")
    public String getCustomerInfo(){
        String username = context.getEnvironment().getProperty("username");
        String password = context.getEnvironment().getProperty("password");
        return username+"\t "+password;
    }
}
