package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/** 
 * @author zhengcj
 * @Date 2020年8月20日 上午10:58:32
 * @version
 * @Description 
 *
 */

@SpringBootApplication
@EnableFeignClients
public class FeignMain80 {
	public static void main(String[] args) {
		SpringApplication.run(FeignMain80.class, args);
	}

}
