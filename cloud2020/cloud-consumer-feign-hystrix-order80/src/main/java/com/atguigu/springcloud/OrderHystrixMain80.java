package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/** 
 * @author zhengcj
 * @Date 2020年8月22日 下午3:52:35
 * @version
 * @Description 
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderHystrixMain80.class, args);
	}
}
