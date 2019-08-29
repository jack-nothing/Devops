package com.kechun.conf;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class AuthSignFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(AuthSignFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain gatewayFilterChain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        HttpHeaders httpHeaders = request.getHeaders();
        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        if (request.getMethod().name().equalsIgnoreCase("OPTIONS")) {
            JSONObject message = new JSONObject();
            message.put("statusCode", -1);
            message.put("msg", "请求类型错误!!!");
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }

        logger.info("==================");
        String url = request.getPath().pathWithinApplication().value();
        logger.info("请求URL:"+url);
        logger.info("method:"+request.getMethod());
        //获取header
        String appKey = request.getHeaders().getFirst("token");
        logger.info("appKey："+appKey);
        //请求的body
        Flux<DataBuffer> flux = request.getBody();
        //这里如何解析出请求的报文呢？
//        exchange.transformUrl();
        return gatewayFilterChain.filter(exchange.mutate().request(request).build());

    }

    @Override
    public int getOrder() {
        return -200;
    }
}