package com.xtl.controller;

import com.xtl.service.NacsoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName NacosConsumerController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 15:51
 */
@RestController
public class NacosConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private NacsoService nacsoService;

    @GetMapping("/consumerInfo")
    public String consumerInfo(){
        ServiceInstance instance = loadBalancerClient.choose("nacos-provider");
        String url=String.format("http://%s:%s/getServerPort",instance.getHost(),instance.getPort());
        return restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/openFeign/getProviderPort")
    public String getProviderPort(){
        return nacsoService.getServerPort();
    }

    @GetMapping("/openFeign/getAppName")
    public String getAppName(){
        return nacsoService.getAppName();
    }

    @GetMapping("/openFeign/getCustomerInfo")
    public String getCustomerInfo(){
        return nacsoService.getCustomerInfo();
    }

}
