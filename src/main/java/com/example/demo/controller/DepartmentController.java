package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pagination;
import com.example.demo.model.Status;
import com.example.demo.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/departments")
@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService deparmentService; 
	
	@GetMapping("/datatable")
	public Pagination getDepartmentsDatatable(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
		try {
			return deparmentService.getDepartmentsDatatable(page,size);
		}catch(Exception ex) {
			return new Pagination();
		}
	}
	
	@GetMapping("/getAllDepartments")
	public Status getAllDepartments() {
		try {
			return deparmentService.getAllDepartments();
		}catch(Exception ex) {
			return new Status();
		}
	}

}
