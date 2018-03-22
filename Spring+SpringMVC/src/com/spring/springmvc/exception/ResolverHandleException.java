package com.atguigu.spring.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResolverHandleException {
/*	// 定义一个方法自己处理异常
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e) {
		System.out.println("---异常的信息是---：" + e);
		return "errors";
	}*/
}
