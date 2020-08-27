package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/** 
 * @author zhengcj
 * @Date 2020年8月22日 下午8:24:15
 * @version
 * @Description 
 *
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {

	@Override
	public String paymentInfo_OK(Integer id) {
		return "PaymentFallBackService---paymentInfo_OK--o(╥﹏╥)o";
	}

	@Override
	public String paymentInfo_TimeOut(Integer id) {
		return "PaymentFallBackService---paymentInfo_TimeOut--o(╥﹏╥)o";
	}

}
