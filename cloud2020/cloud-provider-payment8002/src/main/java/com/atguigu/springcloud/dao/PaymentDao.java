package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entities.Payment;

/** 
 * @author zhengcj
 * @Date 2020年7月31日 下午5:10:58
 * @version
 * @Description 
 *
 */
@Mapper
public interface PaymentDao {
	
	public int create(Payment ayment);

	public Payment getPaymentById(Long id);
}
