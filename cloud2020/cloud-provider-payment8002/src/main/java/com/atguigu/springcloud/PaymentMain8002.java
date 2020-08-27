package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/** 
 * @author zhengcj
 * @Date 2020年7月30日 下午10:36:16
 * @version
 * @Description 
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8002.class, args);
	}

}
