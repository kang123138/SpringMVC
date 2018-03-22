package com.atguigu.springmvc.handler;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

@Controller
public class SpringmvcHandler {
	
	// 注入EmployeeDao
	@Autowired
	private EmployeeDao employeeDao;
	
	// 注入DepartmentDao
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/testI18n")
	public String testI18n() {
		System.out.println("测试国际化");
		return "i18n";
	}
	
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String testGet(Map<String, Object> map) {
		Collection<Employee> emps = employeeDao.getAll();
		map.put("emps", emps);
		return "list";
	}
	
	// 添加员ym
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String addEmp(Map<String, Object> map) {
		// 获取所有部门
		Collection<Department> depts = departmentDao.getDepartments();
		// 将所有部门放到map中  
		map.put("depts", depts);
		map.put("command", new Employee());
		return "input";   
	}
	
	// tianjia xinyuangon
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String addEmployee(Employee employee) {
		System.out.println("ninyao tainjia de shi " + employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
}
