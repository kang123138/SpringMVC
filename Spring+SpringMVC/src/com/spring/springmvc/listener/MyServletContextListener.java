package com.atguigu.spring.springmvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("MyServletContextListener对象被销毁了");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("MyServletContextListener对象被创建了");
		
	}
	
}
