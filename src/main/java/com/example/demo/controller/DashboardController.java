package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Status;
import com.example.demo.service.DashboardService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/dashboard")
@RestController
public class DashboardController {
	
	@Autowired
	DashboardService dashboardService;
	
	@GetMapping("/getCountOfEmployeeByDepartment")
	public Status getCountOfEmployeeByDepartment() {
		try {
			return dashboardService.getCountOfEmployeeByDepartment();
		}catch(Exception ex) {
			return new Status();
		}
	}
	
	@GetMapping("/getCountOfEmployeeByRole")
	public Status getCountOfEmployeeByRole() {
		try {
			return dashboardService.getCountOfEmployeeByRole();
		}catch(Exception ex) {
			return new Status();
		}
	}

}
