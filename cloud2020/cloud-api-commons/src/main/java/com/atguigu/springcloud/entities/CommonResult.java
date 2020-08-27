package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * @author zhengcj
 * @Date 2020年7月30日 下午10:42:58
 * @version
 * @Description 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
	private Integer code;
	private String message;
	private T data;
	
	public CommonResult(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
