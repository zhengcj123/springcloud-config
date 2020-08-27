package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** 
 * @author zhengcj
 * @Date 2020年8月4日 下午9:18:45
 * @version
 * @Description 
 *
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
//	@LoadBalanced // 开启负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
