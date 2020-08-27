package com.atguigu.springcloud.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.ctc.wstx.util.StringUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/** 
 * @author zhengcj
 * @Date 2020年8月25日 下午10:09:29
 * @version
 * @Description 
 *
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter,Ordered{

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String name = exchange.getRequest().getQueryParams().getFirst("username");
		if(StringUtils.isBlank(name)) {
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			log.info("*******o(╥﹏╥)o*****");
			return exchange.getResponse().setComplete();
		}
		log.info("*******卐卐卐卐卐*******");
		return chain.filter(exchange);
	}

}
