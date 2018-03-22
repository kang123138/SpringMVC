package com.atguigu.springmvc.crud.handler;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.entities.Employee;


public class MyConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String arg0) {

		Employee employee = null;
		if (arg0 != null) {
			String[] split = arg0.split("-");
			if (split != null && split.length == 4) {
				// 获取用户名
				String lastName = split[0];
				// 获取邮箱
				String email = split[1];
				// 获取性别
				String gender = split[2];
				// 获取部门编号
				String deptId = split[3];

				// 创建Employee对象
				employee = new Employee();

				employee.setLastName(lastName);
				employee.setEmail(email);
				employee.setGender(Integer.parseInt(gender));

				DepartmentDao departmentDao = new DepartmentDao();
				employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(deptId)));
			}
		}
		return employee;
	}

}
