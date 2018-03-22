package com.atguigu.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class HelloWorld {
	private static final String SUCCESS = "success";
	
	@RequestMapping("/hellowSpringMVC")
	public String HelloWorld() {
		System.out.println("HelloWorld");
		return "success";
	}
	
	@RequestMapping(value= {"/hellowSpringMVC1","/hellowSpringMVC2"})
	public String testValue() {
		System.out.println("测试value属性");
		return SUCCESS;
	}
	
	@RequestMapping(value="/hellowSpringMVC3",method=RequestMethod.POST)
	public String testMethod() {
		System.out.println("测试method属性");
		return SUCCESS;
	}
	
	@RequestMapping(value="/hellowSpringMVC4",params= {"username=admin1","password"})
	public String testParams() {
		System.out.println("测试Params");
		return SUCCESS;
	}
	
	@RequestMapping(value="/hellowSpringMVC5",headers="Accept-Language=zh-CN,zh;q=0.8")
	public String testHeaders() {
		System.out.println("测试Headers");
		return SUCCESS;
	}
	
	@RequestMapping("/hellowSpringMVC6/**")
	public String testAnt() {
		System.out.println("测试ant风格");
		return SUCCESS;
	}
	
	@RequestMapping("/testVariable/{id}")
	public String testVariable(@PathVariable("id") String id) {
		System.out.println("传入的id是" + id);
		return SUCCESS;
	}
	
	// 测试ReSt风格的get请求
	@RequestMapping(value = "/testREST/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id) {
		System.out.println("获取的订单id是" + id);
		return SUCCESS;
	}
	
	//测试REST风格的POST请求
	@RequestMapping(value="/testREST",method=RequestMethod.POST)
	public String testREST_POST() {
		System.out.println("你正在向数据库中保存订单");
		return SUCCESS;
	}
	
	// 测试REST风格的PUT请求
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.PUT)
	public String testREST_PUT(@PathVariable("id") Integer id) {
		System.out.println("你正在更新的订单是：" + id);
		return SUCCESS;
	}
	
	// 测试REST风格的DELETE请求
	@RequestMapping(value="/testREST/{id}",method=RequestMethod.DELETE) 
	public String testREST_DELETE(@PathVariable("id") Integer id) {
		System.out.println("你正在删除的订单是：" + id);
		return SUCCESS;
	}
	/*
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam("username") String username,
			@RequestParam(value="age",required=false,defaultValue="1010") int age) {
		System.out.println("传入的用户名是：" + username);
		System.out.println("传入的年龄是：" + age);
		return SUCCESS;
	}*/      
	  
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam("username") String username,
			@RequestParam(value="age") Integer age) {
		System.out.println("传入的用户名是：" + username);
		System.out.println("传入的年龄是：" + age);
		return SUCCESS;
	}  
	 
	@RequestMapping("/testRequestCookie")
	public String testRequestHeader(@CookieValue("JSESSIONID") String j) {
		System.out.println("你从这里来" + j);    
		return SUCCESS;  
	}     
}
