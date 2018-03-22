package com.atguigu.spring.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringmvcHandler {

	@RequestMapping("/byeByeSpringMVC")
	public String byeByeSpringMVC() {
		System.out.println("测试SpringMVC的运行流程");
		return "success";
	}
	
	
	
}
