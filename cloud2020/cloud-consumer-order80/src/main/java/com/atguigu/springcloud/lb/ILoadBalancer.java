package com.atguigu.springcloud.lb;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

/** 
 * @author zhengcj
 * @Date 2020年8月19日 下午3:01:06
 * @version
 * @Description 
 *
 */
public interface ILoadBalancer {
	ServiceInstance instance(List<ServiceInstance> serviceInstances); 
}
