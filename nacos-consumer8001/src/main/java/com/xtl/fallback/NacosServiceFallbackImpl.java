package com.xtl.fallback;

import com.xtl.service.NacsoService;
import org.springframework.stereotype.Component;

/**
 * @ClassName NacosServiceFallback
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 16:38
 */
@Component
public class NacosServiceFallbackImpl implements NacsoService {
    @Override
    public String getServerPort() {
        return "服务暂不可用，清稍后再试";
    }

    @Override
    public String getAppName() {
        return "服务暂不可用，清稍后再试";
    }

    @Override
    public String getCustomerInfo() {
        return "获取自定义信息失败，清稍后重试";
    }
}
