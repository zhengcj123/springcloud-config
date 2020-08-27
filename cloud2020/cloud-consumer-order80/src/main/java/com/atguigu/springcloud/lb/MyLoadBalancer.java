package com.atguigu.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/** 
 * @author zhengcj
 * @Date 2020年8月19日 下午3:03:58
 * @version
 * @Description 
 *
 */
@Component
public class MyLoadBalancer implements ILoadBalancer {
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	
	public final int incrementAndGetModulo() {
		int current,next;
		do {
			current = this.atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : current+1;
		}while(!atomicInteger.compareAndSet(current, next));
		return next;
	}

	@Override
	public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
		int index = incrementAndGetModulo()%serviceInstances.size();
		return serviceInstances.get(index);
	}

}
