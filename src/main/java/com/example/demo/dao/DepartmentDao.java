package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Departments;

@Component
@PropertySource(value = "classpath:queries.properties", ignoreResourceNotFound = true)
public class DepartmentDao {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getAllDepartmentsCount() {
		
		return jdbcTemplate.queryForObject("select count(*) from departments", Integer.class);
		
	}
	
	public List<Departments> getDepartmentsDatatable(int page, int size){
		
		page = size * page;	
		
//		System.out.println("page = "+page);
		List<Departments> departmentsList = new ArrayList<Departments>();
		
		String query = env.getProperty("getAllDepartments");
		
		departmentsList = jdbcTemplate.query(query, new Object[] {page,size},
				 new BeanPropertyRowMapper<Departments>(Departments.class)); 
		
		return departmentsList;
	}
	
	public List<Departments> getAllDepartments(){
	
		List<Departments> departmentsList = new ArrayList<Departments>();
		
		String query = "select * from departments";
		
		departmentsList = jdbcTemplate.query(query,
				 new BeanPropertyRowMapper<Departments>(Departments.class)); 
		
		return departmentsList;
	}

}
