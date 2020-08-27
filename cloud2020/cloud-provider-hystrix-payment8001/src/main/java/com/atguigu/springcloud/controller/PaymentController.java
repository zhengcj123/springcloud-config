package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhengcj
 * @Date 2020年8月22日 上午11:39:47
 * @version
 * @Description
 *
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@GetMapping("/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_OK(id);
		log.info("*******result:" + result);
		return result;
	}

	@GetMapping("/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_TimeOut(id);
		log.info("*******result:" + result);
		return result;
	}

	@GetMapping("/hystrix/circuitBreak/{id}")
	public String paymentCircuitBreak(@PathVariable("id") Integer id) {
		return paymentService.paymentCircuitBreak(id);
	}
}
