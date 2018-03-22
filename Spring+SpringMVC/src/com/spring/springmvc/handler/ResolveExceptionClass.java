package com.atguigu.spring.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.spring.springmvc.exception.UnAuthorizedException;

@Controller
public class ResolveExceptionClass {

	@RequestMapping("/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
		System.out.println(10/i);
		return "success";
	}
	
	// 把异常带到错误页面
	@ExceptionHandler(value=ArithmeticException.class)
	public ModelAndView takeExceptionToErrorPage(Exception e) {
		// 创建ModelAndView对象
		ModelAndView mv = new ModelAndView();
		
		// 设置模型数据
		mv.addObject("exception",e);
		
		// 设置视图
		mv.setViewName("errors");
		return mv;
	}
	
/*	// 定义一个方法自己处理异常
	@ExceptionHandler(value=ArithmeticException.class)
	public String handleException(Exception e) {
		System.out.println("异常的信息是：" + e);
		return "errors";
	}*/
	
/*	@ExceptionHandler(value=Exception.class)
	public String handleException2(Exception e) {
		System.out.println("[异常的信息是[：" + e);
		return "errors";
	}*/
	
	@RequestMapping("/testResponseStatus")
	public String testResponseStatus(@RequestParam("age") int age) {
		
		if(age < 18) {
			throw new UnAuthorizedException();
		}
		return "success";
	}
	
}
