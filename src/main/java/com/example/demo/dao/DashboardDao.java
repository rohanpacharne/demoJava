package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.CountOfEmployeeByDepartment;
import com.example.demo.model.Departments;

@Component
@PropertySource(value = "classpath:queries.properties", ignoreResourceNotFound = true)
public class DashboardDao {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CountOfEmployeeByDepartment> getCountOfEmployeeByDepartment(){
		
		List<CountOfEmployeeByDepartment> countOfEmployeeByDepartmentList = new ArrayList<CountOfEmployeeByDepartment>();
		
		String query = env.getProperty("getCountOfEmployeeByDepartment");
		
		countOfEmployeeByDepartmentList = jdbcTemplate.query(query,
				 new BeanPropertyRowMapper<CountOfEmployeeByDepartment>(CountOfEmployeeByDepartment.class)); 
		
		return countOfEmployeeByDepartmentList;
	}
	
	public List<CountOfEmployeeByDepartment> getCountOfEmployeeByRole(){
		
		List<CountOfEmployeeByDepartment> countOfEmployeeByRoleList = new ArrayList<CountOfEmployeeByDepartment>();
		
		String query = env.getProperty("getCountOfEmployeeByRole");
		
		countOfEmployeeByRoleList = jdbcTemplate.query(query,
				 new BeanPropertyRowMapper<CountOfEmployeeByDepartment>(CountOfEmployeeByDepartment.class)); 
		
		return countOfEmployeeByRoleList;
	}

}
