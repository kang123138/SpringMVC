package com.atguigu.spring.springmvc.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.spring.springmvc.entities.Employee;
import com.atguigu.spring.springmvc.service.EmployeeService;

@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeService employeeService;

	// 获取所有员工
	@RequestMapping("/getemps")
	public String getEmployees(Map<String, Object> map) {
		List<Employee> employees = employeeService.getEmployees();
		map.put("emps", employees);
		System.out.println("handler被创建");
		return "success";
	}
}
