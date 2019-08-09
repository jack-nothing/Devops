package com.kechun.conf;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Component
public class AuthSignFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(AuthSignFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain gatewayFilterChain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        logger.info("==================");
        String url = serverHttpRequest.getPath().pathWithinApplication().value();
        logger.info("请求URL:"+url);
        logger.info("method:"+serverHttpRequest.getMethod());
        //获取header
        String appKey = serverHttpRequest.getHeaders().getFirst("token");
        logger.info("appKey："+appKey);
        //请求的body
        Flux<DataBuffer> flux = serverHttpRequest.getBody();
        //这里如何解析出请求的报文呢？

//        exchange.transformUrl();
        return gatewayFilterChain.filter(exchange.mutate().request(serverHttpRequest).build());

    }

    @Override
    public int getOrder() {
        return -200;
    }
}