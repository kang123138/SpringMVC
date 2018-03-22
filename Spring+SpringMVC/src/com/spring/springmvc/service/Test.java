package com.atguigu.spring.springmvc.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.atguigu.spring.springmvc.entities.Employee;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
		System.out.println(jdbcTemplate);
		String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		//调用jdbcTemplate的query方法
		List<Employee> emps = jdbcTemplate.query(sql, rowMapper);
		System.out.println(emps);
	}

}
