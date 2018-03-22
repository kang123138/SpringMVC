package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InternalHandler {
	
	
	@RequestMapping("/testInternalFile")
	public String testInternalFile() {
		System.out.println("国际化");
		return "i18n";
	}
}
