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
import com.example.demo.model.Roles;

@Component
@PropertySource(value = "classpath:queries.properties", ignoreResourceNotFound = true)
public class RoleDao {

	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Roles> getAllRoles(){
		
		List<Roles> departmentsList = new ArrayList<Roles>();
		
		String query = env.getProperty("getAllRoles");
		
		departmentsList = jdbcTemplate.query(query,
				 new BeanPropertyRowMapper<Roles>(Roles.class)); 
		
		return departmentsList;
	}

}
