package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/** 
 * @author zhengcj
 * @Date 2020年8月23日 下午4:35:15
 * @version
 * @Description 
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardMain9001.class, args);
	}
}
