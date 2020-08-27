package com.atguigu.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

/**
 * 
 * @author zhengcj
 * @Date 2020年8月22日 上午11:39:47
 * @version
 * @Description
 */
@Service
public class PaymentService {
	
	@Value("${server.port}")
	private String port;
	
	//成功
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }

    /*
     * HystrixCommand:一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbckMethod调用类中的指定方法
     *  execution.isolation.thread.timeoutInMilliseconds:线程超时时间3秒钟
     */
    @HystrixCommand(fallbackMethod="paymentInfo_TimeOutHandle",commandProperties= {
    		@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id){
//    	int timeNumber = 10/0;
        int timeNumber = 5;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"8001   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber;
    }
    
    public String paymentInfo_TimeOutHandle(Integer id){
    	return "线程池："+Thread.currentThread().getName()+"8001  超时或运行故障  paymentInfo_TimeOutHandle,id：  "+id;
    }
    
    //====服务熔断

    /**
     * 在10秒窗口期中10次请求有6次是请求失败的,断路器将起作用
     *
     * @param id
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreakFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreak(Integer id) {
    	if(id < 0) {
    		throw new RuntimeException("id不能小于0");
    	}
    	String uuid = IdUtil.simpleUUID();
    	return Thread.currentThread().getName()+"\t流水号"+uuid;
    }
    
    public String paymentCircuitBreakFallBack(Integer id) {
    	return "id 不能小于0 o(╥﹏╥)o\t"+id;
    }

}
