package org.example;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 权限认证的全局过滤器
 */
@Component
@Order(1)//该过滤器的优先级
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();//拿到请求头的数据
        MultiValueMap<String, String> queryParams = request.getQueryParams();//拿到请求体的数据
        String authorization = queryParams.getFirst("authorization");
        if ("admin".equals(authorization)){
            return chain.filter(exchange);//放行
        }
        //拦截请求
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.FORBIDDEN);//设置状态码
        return exchange.getResponse().setComplete();//完成拦截
    }
}
