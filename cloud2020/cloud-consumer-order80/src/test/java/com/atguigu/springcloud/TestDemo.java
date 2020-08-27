package com.atguigu.springcloud;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import cn.hutool.core.collection.CollectionUtil;

/**
 * @author zhengcj
 * @Date 2020年8月5日 下午3:18:30
 * @version
 * @Description
 *
 */
public class TestDemo {

	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	@Test
	public void test01() {
		List<Integer> list = CollectionUtil.newArrayList(1, 2, 3);
		System.out.println(list);
	}

	public static void main(String[] args) {
		// int current,next;
		// do {
		// current = atomicInteger.get();
		// next = current >= Integer.MAX_VALUE ? 0 : current+1;
		// }while(!atomicInteger.compareAndSet(current, next));

		int num = getNum();
		System.out.println(num);

	}

	public static final int getNum() {
		for (;;) {
			// CAS有3个操作数，
			// 内存值V(atomicInteger)，旧的预期值A(current)，要修改的新值B(next)。
			// 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做
			int current = atomicInteger.get();
			int next = current + 1;
			if (atomicInteger.compareAndSet(current, next)) {
				return next;
			}
		}
	}

}
