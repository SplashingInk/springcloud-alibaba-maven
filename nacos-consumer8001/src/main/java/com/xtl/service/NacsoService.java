package com.xtl.service;


import com.xtl.fallback.NacosServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-provider",fallback = NacosServiceFallbackImpl.class)
public interface NacsoService {

    /**
     * 返回服务端口号
     * @return 服务接口
     */
    @GetMapping("/getServerPort")
    String getServerPort();

    /**
     * 返回服务名
     * @return 服务名
     */
    @GetMapping("/getAppName")
    String getAppName();

    /**
     * 返回自定义属性
     * @return 自定义属性
     */
    @GetMapping("/getCustomerInfo")
    String getCustomerInfo();
}
