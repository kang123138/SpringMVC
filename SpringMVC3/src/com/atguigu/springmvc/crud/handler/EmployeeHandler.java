package com.atguigu.springmvc.crud.handler;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {

	// 注入EmployeeDao
	@Autowired
	private EmployeeDao employeeDao;

	// 注入DepartmentDao
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public String getAllEmps(Map<String, Object> map) {
		// 调用EmployeeDao中的获取所有员工的方法
		Collection<Employee> emps = employeeDao.getAll();
		// 把员工放进map集合中
		map.put("emps", emps);
		return "list";
	}

	// 添加员工之页面
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String AddEmployee(Map<String, Object> map) {
		// 获取部门
		Collection<Department> departments = departmentDao.getDepartments();
		map.put("depts", departments);
		map.put("command", new Employee());
		return "input";
	}

	// 添加员工
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String saveEmployee(Employee employee) {
		// 调用EmployeeDao方法
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	// 删除员工
	@RequestMapping(value="/deleteEmp/{id}",method=RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") Integer id) {
		// 调用EmployeeDao方法删除员工
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	// 更新员工之页面
	@RequestMapping(value="/updateEmp/{id}",method=RequestMethod.GET)
	public String updateEmp(@PathVariable("id") Integer id, Map<String, Object> map) {
		// 调用EmployeeDao中的方法获取员工
		Employee employee = employeeDao.get(id);
		// 把employee对象放入map集合中
		map.put("command", employee);
		// 获取部门
		Collection<Department> departments = departmentDao.getDepartments();
		map.put("depts", departments);
		return "input";
	}
	
	// 更新员工
	@RequestMapping(value="/updateEmp/{id}",method=RequestMethod.PUT)
	public String updateEmployee(Employee employee) {
		// 调用EmployeeDao中的方法更新员工
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}
