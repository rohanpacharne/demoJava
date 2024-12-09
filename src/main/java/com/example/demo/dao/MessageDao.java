package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:queries.properties", ignoreResourceNotFound = true)
public class MessageDao {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String getMessageNameByCode(String messageCode) {
		
		String query = env.getProperty("getMessageNameByCode");
		
		String messageName =  jdbcTemplate.queryForObject(query,new Object[] {messageCode}, String.class);
		
		return messageName;
	}

}
