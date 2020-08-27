package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/** 
 * @author zhengcj
 * @Date 2020年8月11日 下午10:45:50
 * @version
 * @Description 
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8004.class, args);
	}

}
