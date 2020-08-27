package com.atguigu.springcloud.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/payment")
public class PaymentController {
	
	@Value("${server.port}")
	private String serverPort;
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
       int result = paymentService.create(payment);
       log.info("*****插入结果："+result);
       if (result>0){  //成功
           return new CommonResult<Integer>(200,"插入数据库成功"+serverPort,result);
       }else {
           return new CommonResult<Integer>(444,"插入数据库失败",null);
       }
    }
    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult<Payment>(200,"查询成功"+serverPort,payment);
        }else {
            return new CommonResult<Payment>(444,"没有对应记录，查询ID："+id,null);
        }
    }
    
    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    
    @GetMapping(value="/feign/timeOut")
    public String getFeignTimeOut() {
    	try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return serverPort;
    }
     

}
 
 
