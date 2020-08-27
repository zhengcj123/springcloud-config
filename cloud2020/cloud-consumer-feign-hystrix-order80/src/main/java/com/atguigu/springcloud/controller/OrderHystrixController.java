package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/** 
 * @author zhengcj
 * @Date 2020年8月22日 下午3:56:37
 * @version
 * @Description 
 *
 */
@RestController
@RequestMapping("consumer/payment")
// @DefaultProperties 要与@HystrixCommand一起使用
// @DefaultProperties(defaultFallback="payment_Global_FallbackMethod")
public class OrderHystrixController {
	
	@Autowired
	private PaymentHystrixService  paymentService;
	
	@GetMapping("/hystrix/ok/{id}")
//	@HystrixCommand
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		try {
			if(id.intValue() == 0) {
				throw new RuntimeException("id不能为0");
			}
			System.out.println("===========");
			id = 10/0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return paymentService.paymentInfo_OK(id);
	}

	
	@GetMapping("/hystrix/timeout/{id}")
//	@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
//	})
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		try {
			id = 10/0;
		}catch (Exception e) {
			e.printStackTrace();
		}
	    return paymentService.paymentInfo_TimeOut(id);
	}

	//兜底方法
	public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
	    return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
	}
	 

    /**
     * 全局fallback方法
     *
     * @return
     */
    private String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后再试。";
    }

}
