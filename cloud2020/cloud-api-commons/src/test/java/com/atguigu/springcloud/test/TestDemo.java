package com.atguigu.springcloud.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

/** 
 * @author zhengcj
 * @Date 2020年8月5日 下午3:18:30
 * @version
 * @Description 
 *
 */
public class TestDemo {
	
	@Test
	public void test01() {
		
		String[] split = StrUtil.split("a,b,c,d,e", ",");
		String join = CollectionUtil.join(Arrays.asList(split), ",");
		System.out.println(join);
		
		List<Integer> list = CollectionUtil.newArrayList(1,2,3);
		System.out.println(list);
		
		String[] keys = new String[]{"a", "b", "c"};
		Integer[] values = new Integer[]{1, 2, 3};
		Map<String, Integer> map = CollectionUtil.zip(Arrays.asList(keys),Arrays.asList(values));
		System.out.println(map);    // {b=2, c=3, a=1}

		String a = "a,b,c";
		String b = "1,2,3";
		Map<String, String> map2 = CollectionUtil.zip(a,b, ",");
		System.out.println(map2);   // {b=2, c=3, a=1} 
		
		String[] col= new String[]{"a","b","c","d","e"};
		String str = CollectionUtil.join(Arrays.asList(col), "#"); //str -> a#b#c#d#e
		System.out.println(str);
	}
	
	@Test
	public void test02() {
		//Integer比较器
		Comparator<Integer> comparator = new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};

		//新建三个列表，CollectionUtil.newArrayList方法表示新建ArrayList并填充元素
		List<Integer> list1 = CollectionUtil.newArrayList(1, 2, 3);
		List<Integer> list2 = CollectionUtil.newArrayList(2, 5, 6);
		List<Integer> list3 = CollectionUtil.newArrayList(7, 8, 9);

		//参数表示把list1,list2,list3合并并按照从小到大排序后，取0~2个（包括第0个，不包括第2个），结果是[1,2]
		List<Integer> result = CollectionUtil.sortPageAll(0, 5, comparator, list1, list2, list3);
		System.out.println(result);     //输出 [1,2]
		
	}

}
