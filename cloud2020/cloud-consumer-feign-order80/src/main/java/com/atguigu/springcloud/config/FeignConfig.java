package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/** 
 * @author zhengcj
 * @Date 2020年8月20日 下午9:32:55
 * @version
 * @Description 
 *
 */
@Configuration
public class FeignConfig {
	@Bean
	Logger.Level getfeignLoggerLevel(){
		return Logger.Level.FULL;
	}
}
