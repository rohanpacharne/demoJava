package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employees;
import com.example.demo.model.Pagination;
import com.example.demo.model.Status;
import com.example.demo.service.EmployeeService;
import com.example.demo.exception.CustomException;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/employees")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	 @GetMapping("/getAllEmployeesPagination")
	    public Page<Employees> getEmployees(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        return employeeService.getEmployees(page, size);
	    }
	
	@GetMapping("/datatable")
	public Pagination getAllEmployees(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
		try {
			return employeeService.getAllEmployees(page,size);
		}catch(Exception ex) {
			return new Pagination();
		}
	}
	
	@PostMapping("/update")
	public Status update(@RequestBody Employees employees) {
		try {
			return employeeService.update(employees);
		}catch(Exception ex) {
			return new Status();
		}
	}
	
	@PostMapping("/save")
	public Status save(@RequestBody Employees employees) {
		try {
			return employeeService.save(employees);
		}catch(Exception ex) {
			return new Status();
		}
	}
	
	@GetMapping("/delete/{employeeId}")
	public Status save(@PathVariable Long employeeId) {
		try {
			return employeeService.delete(employeeId);
		}catch(Exception ex) {
			return new Status();
		}
	}
	
	@GetMapping("/getEmployeeById/{employeeId}")
	public Status getEmployeeById(@PathVariable Long employeeId) {
		try {
			return employeeService.getEmployeeById(employeeId);
		}catch(Exception ex) {
			return new Status();
		}
	}
	
	@GetMapping("/practiceException")
	public ResponseEntity<Map<String, String>> practiceException() {
	    Map<String, String> response = new HashMap<>();
	    try {
	        boolean condition = true;
	        if (condition) {
	        	System.out.println("in if");
	            throw new CustomException();
	        }
	        response.put("message", "Success");
	        return ResponseEntity.ok(response);
//	    } catch (CustomException ex) {
//	    	System.out.println("in CustomException");
//	        response.put("error", "CustomException occurred: " + ex.getMessage());
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    } 
	        catch (Exception ex) {
	    	System.out.println("in Exception");
	        response.put("error", "An error occurred");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}


}
