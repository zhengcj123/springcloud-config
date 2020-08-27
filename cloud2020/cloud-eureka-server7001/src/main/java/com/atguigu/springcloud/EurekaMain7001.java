package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/** 
 * @author zhengcj
 * @Date 2020年8月5日 下午10:40:58
 * @version
 * @Description 
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7001.class, args);
	}
}
