package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeeRepository;

@Component
@PropertySource(value = "classpath:queries.properties", ignoreResourceNotFound = true)
public class LoginDao {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employees getLoginDetails(String email) {
		
		List<Employees> employeesList = new ArrayList<Employees>();
		
		String query = "select * from employees where email = ?";
		
		employeesList = jdbcTemplate.query(query, new Object[] {email},
				 new BeanPropertyRowMapper<Employees>(Employees.class)); 
	
		return employeesList.get(0);

	}
}
