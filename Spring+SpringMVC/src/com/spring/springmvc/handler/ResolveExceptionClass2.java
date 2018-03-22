package com.atguigu.spring.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResolveExceptionClass2 {

	@RequestMapping("/testExceptionHandlerExceptionResolver2")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
		System.out.println(10/i);
		return "success";
	}
}
