package com.atguigu.spring.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.spring.springmvc.dao.EmployeeDao;
import com.atguigu.spring.springmvc.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
//	public EmployeeService(){
//		System.out.println("service被创建了");
//	}
	
	// 获取员工
	public List<Employee> getEmployees() {
		List<Employee> emps = employeeDao.getEmployees();
		return emps;
	}
}
