package com.atguigu.spring.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.atguigu.spring.springmvc.entities.Employee;

@Repository
public class EmployeeDao {
	// 引入JdbcTemplate
	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	// 获取所有员工方法
	public List<Employee> getEmployees() {
		//写sql语句
		String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		//调用jdbcTemplate的query方法
		List<Employee> emps = jdbcTemplate.query(sql, rowMapper);
		return emps;
	}
}
