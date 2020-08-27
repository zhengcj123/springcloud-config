package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentFeignService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhengcj
 * @Date 2020年8月20日 上午11:01:58
 * @version
 * @Description
 *
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignClientController {

	@Autowired
	private IPaymentFeignService paymentFeignService;

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		log.info("主键为：" + id);
		return paymentFeignService.getPaymentById(id);
	}

	@GetMapping(value = "/payment/feign/timeOut")
	public String getFeignTimeOut() {
		return paymentFeignService.getFeignTimeOut();
	}

}
