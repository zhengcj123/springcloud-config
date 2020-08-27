package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * @author zhengcj
 * @Date 2020年7月30日 下午10:38:22
 * @version
 * @Description 
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{
	private Long id;
	private String serial;
	
	

}
