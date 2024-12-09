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
public class EmployeeDao {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public int getAllEmployeesCount() {
		
		return jdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
		
	}
	
	public String getDepartmentNameById(Long depId) {
		
		String query = env.getProperty("getDepartmentNameById");
		
		return jdbcTemplate.queryForObject(query, new Object[] {depId},  String.class);
		
	}
	
	public String getRoleNameById(Long roleId) {
		
		String query = env.getProperty("getRoleNameById");
		
		return jdbcTemplate.queryForObject(query, new Object[] {roleId},  String.class);
		
	}
	
	public List<Employees> getAllEmployees(int page, int size){
		
		page = size * page;	
		
//		System.out.println("page = "+page);
		List<Employees> employeesList = new ArrayList<Employees>();
		
		String query = env.getProperty("getAllEmployees");
		
		employeesList = jdbcTemplate.query(query, new Object[] {page,size},
				 new BeanPropertyRowMapper<Employees>(Employees.class)); 
		
		return employeesList;
	}
	
	public Employees update(Employees employees) {
		
		Employees newEmployees = employeeRepository.save(employees);
		
		String query = env.getProperty("update");
		
		String empCode = generateEmployeeCode(newEmployees);
		
		int res = jdbcTemplate.update(query,empCode,newEmployees.getEmployeeId());
		
		if(res!=0) {
			return newEmployees;
		}else {
			return null;
		}
	}
	
	public Employees save(Employees employees) {
		Employees newEmployees = employeeRepository.save(employees);
		
		String query = env.getProperty("update");
		
		String empCode = generateEmployeeCode(newEmployees);
		
		int res = jdbcTemplate.update(query,empCode,newEmployees.getEmployeeId());
		
		if(res!=0) {
			return newEmployees;
		}else {
			return null;
		}
	}
	
	public boolean delete(Long employeeId) {
		
		String query = env.getProperty("deleteEmployeeByEmployeeId");
		
		int res = jdbcTemplate.update(query,employeeId); 
		
		if(res!=0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Employees getEmployeeById(Long employeeId) {
		
		List<Employees> employeesList = new ArrayList<Employees>();
		
		String query = env.getProperty("getEmployeeByEmployeeId");
		
		employeesList = jdbcTemplate.query(query, new Object[] {employeeId},
				 new BeanPropertyRowMapper<Employees>(Employees.class)); 
		
		if(employeesList.size()>0) {
			return employeesList.get(0);
		}
		
		return null;
	}
	
	public String generateEmployeeCode(Employees employees) {
		String empRole = "";
		String empDep = "";
		
		empRole = getRoleNameById(employees.getRoleId());
				
		if(empRole.length()>=3) {
			empRole = empRole.substring(0,3).toUpperCase();
		}else {
			empRole = empRole.substring(0,2).toUpperCase();
		}
		
		empDep = getDepartmentNameById(employees.getDepartmentId());
				
		if(empDep.length()>=3) {
			empDep = empDep.substring(0,3).toUpperCase();
		}else {
			empDep = empDep.substring(0,2).toUpperCase();
		}		
		
		String empCode = empRole+"-"+employees.getFirstName().substring(0,1).toUpperCase()+
				employees.getLastName().substring(0,1).toUpperCase()+"-"+employees.getEmployeeId()+"-"+
				employees.getHireDate().toString().substring(2,4)+"-"+empDep;
		return empCode;
	}
	

}
