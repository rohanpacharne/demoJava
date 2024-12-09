package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.CommonMasterValues;

@Component
@PropertySource(value = "classpath:queries.properties", ignoreResourceNotFound = true)
public class CommonMasterValuesDao {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CommonMasterValues> getCommonMasterValuesByName(String masterName){
		
		List<CommonMasterValues> commonMasterValuesList = new ArrayList<CommonMasterValues>();
		
		String query = env.getProperty("getCommonMasterValuesByName");
		
		commonMasterValuesList = jdbcTemplate.query(query,new Object[] {masterName},
				 new BeanPropertyRowMapper<CommonMasterValues>(CommonMasterValues.class)); 
		
		return commonMasterValuesList;
	}

}
