package com.xtl.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @ClassName GlobalFilter
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/9 20:04
 */
@Component
public class CustomerGlobalFilter implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(token==null||token.isEmpty()){
            ServerHttpResponse response = exchange.getResponse();
            Map<String,Object> responseData= Maps.newHashMap();
            responseData.put("code",400);
            responseData.put("message","非法请求");
            responseData.put("cause","token is null");
            try {
                ObjectMapper objectMapper=new ObjectMapper();
                byte[] data = objectMapper.writeValueAsBytes(responseData);
                DataBuffer dataBuffer = response.bufferFactory().wrap(data);
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                response.getHeaders().add("Content-Type","application/json;charset=UTF-8");
                return response.writeWith(Mono.just(dataBuffer));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
