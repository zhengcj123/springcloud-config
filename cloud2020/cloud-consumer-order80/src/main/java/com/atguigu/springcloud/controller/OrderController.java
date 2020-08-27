package com.atguigu.springcloud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.ILoadBalancer;

/**
 * @author zhengcj
 * @Date 2020年8月4日 下午9:15:40
 * @version
 * @Description
 *
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ILoadBalancer balancer;
	@Autowired
	private DiscoveryClient discoveryClient;

//	public static final String PAYMENT_URL = "http://localhost:8001"; // 单机版
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; // 集群版

	@GetMapping(value="/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment,CommonResult.class);
	}
	@GetMapping(value="/payment/create2")
	public CommonResult<Payment> create2(Payment payment) {
		ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment,CommonResult.class);
		return entity.getBody();
	}

	@GetMapping(value="/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		 return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
	}
	
	@GetMapping(value="/payment/get2/{id}")
	public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
		return entity.getBody();
	}
	
	@GetMapping(value="/payment/lb")
	public String getPaymentLB() {
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if(serviceInstances.isEmpty()) {
			return null;
		}
		ServiceInstance instance = balancer.instance(serviceInstances);
		URI url = instance.getUri();
		return restTemplate.getForObject(url+"/payment/lb", String.class);
	}
	
}
