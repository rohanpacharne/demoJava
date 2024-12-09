package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Status;
import com.example.demo.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/login")
@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public Status getLoginDetails(@RequestParam String email) {
		try {
			return loginService.getLoginDetails(email);
		}catch(Exception ex) {
			return new Status();
		}
	}

}
