package org.showcase.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@Slf4j
public class LogFilter implements GlobalFilter, Ordered {

    private static final String TRACE_ID = "traceId";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String transId = UUID.randomUUID().toString();
        ServerHttpRequest request = exchange.getRequest().mutate().header(TRACE_ID, transId).build();
        log.debug("log filter transId:{}",transId);
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
