package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Status;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/roles")
@RestController
public class RolesController {

	@Autowired
	RoleService roleService; 
	
	@GetMapping("/getAllRoles")
	public Status getAllRoles() {
		try {
			return roleService.getAllRoles();
		}catch(Exception ex) {
			return new Status();
		}
	}
}
