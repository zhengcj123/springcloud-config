package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/** 
 * 定义服务接口
 * @author zhengcj
 * @Date 2020年8月20日 上午11:02:16
 * @version
 * @Description 
 *
 */
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
@RequestMapping(value="/payment")
public interface IPaymentFeignService {
	
    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value="/feign/timeOut")
    public String getFeignTimeOut();
}
