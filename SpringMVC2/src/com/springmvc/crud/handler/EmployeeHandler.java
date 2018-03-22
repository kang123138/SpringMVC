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
import com.atguigu.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao; 
	
	@Autowired
	private DepartmentDao departmentDao;
	
	// 获取所有员工信息
	@RequestMapping("/emps")
	public String getAll(Map<String, Object> map) {
		
		// 从EmployeeDao数据库中获取所有员工的信息
		Collection<Employee> emps = employeeDao.getAll();
		
		// 把结果放入request域中
		map.put("emps", emps);
		return "list";
	}
	
	// 去添加员工信息页面
	@RequestMapping("/empAdd")
	public String empAdd(Map<String, Object> map) {
		// 获取所有的部门
		map.put("depts", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	// 添加新员工
	@RequestMapping(value="/empAdd",method=RequestMethod.POST)
	public String addEMployee(Employee employee) {
		// System.out.println(employee);
		// 调用数据库存入新员工
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	// 删除员工
	@RequestMapping(value="/deleteEmp/{id}",method=RequestMethod.DELETE)
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
//		System.out.println(id);
		// 调用方法删除指定员工
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	// 去修改员工信息的页面
	@RequestMapping(value="/updateEmp/{id}",method = RequestMethod.GET)
	public String updateEmployee(@PathVariable("id") Integer id, Map<String, Object> map) {
		// 根据id查出员工信息
		Employee employee = employeeDao.get(id);
		// System.out.println(employee);
		// 将employee放到map中
//		map.put("employee", employee);
		 map.put("command", employee);

		// 获取所有的部门
		map.put("depts", departmentDao.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="/updateEmp/{id}",method = RequestMethod.PUT)
	public String update(Employee employee) {
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
}
