package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/** 
 * @author zhengcj
 * @Date 2020年7月30日 下午10:36:16
 * @version
 * @Description 
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHistrixMain8001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentHistrixMain8001.class, args);
	}
	
	 
	@Bean
	public ServletRegistrationBean getServlet(){
	    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
	    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
	    registrationBean.setLoadOnStartup(1);
	    registrationBean.addUrlMappings("/hystrix.stream");
	    registrationBean.setName("HystrixMetricsStreamServlet");
	    return registrationBean;
	}
	 


}
