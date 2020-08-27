package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/** 
 * @author zhengcj
 * @Date 2020年8月18日 下午10:04:37
 * @version
 * @Description 
 *
 */
@Configuration
public class MySelfRule {
	@Bean
	public IRule getRule() {
		return new RandomRule();
	}
}
