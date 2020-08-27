package com.atguigu.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhengcj
 * @Date 2020年8月11日 下午10:48:12
 * @version
 * @Description
 *
 */
@RestController
@Slf4j
public class PaymentController {
	@Value("${server.port}")
	private String serverPort;

	@GetMapping(value = "/payment/zk")
	public String paymentzk() {
		log.info("port:"+serverPort);
		return "springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
	}
}
