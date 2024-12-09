package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Status;
import com.example.demo.service.CommonMasterValuesService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/commonmastervalues")
@RestController
public class CommonMasterValuesController {
	
	@Autowired
	CommonMasterValuesService commonMasterValuesService; 
	
	@GetMapping("/getCommonMasterValuesByName/{masterName}")
	public Status getCommonMasterValuesByName(@PathVariable String masterName) {
		try {
			return commonMasterValuesService.getCommonMasterValuesByName(masterName);
		}catch(Exception ex) {
			return new Status();
		}
	}
	

}
