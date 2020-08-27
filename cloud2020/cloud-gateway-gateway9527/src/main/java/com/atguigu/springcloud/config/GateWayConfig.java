package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
 * @author zhengcj
 * @Date 2020年8月25日 下午9:04:15
 * @version
 * @Description 
 *
 */
@Configuration
public class GateWayConfig {
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		Builder routes = builder.routes();
		RouteLocator build = routes
				.route("rote1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
				.route("rote2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"))
				.route("rote3", r -> r.path("/payment/lb/**").uri("lb://CLOUD-PAYMENT-SERVICE"))
				.build();
		return build;
	}

}
