package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DashboardDao;
import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.CountOfEmployeeByDepartment;
import com.example.demo.model.Departments;
import com.example.demo.model.Status;

@Service
public class DashboardService {
	
	@Autowired
	DashboardDao dashboardDao;
	
	@Autowired
	MessageService messageService;
	
	public Status getCountOfEmployeeByDepartment() {
		
		Status status = new Status();
		
		List<CountOfEmployeeByDepartment> countOfEmployeeByDepartmentList = dashboardDao.getCountOfEmployeeByDepartment();
		
		try {
		if(countOfEmployeeByDepartmentList.size()>0) {
			status.setCode(1);
			status.setMessage(messageService.getMessageNameByCode("FETCHED_SUCCESSFULLY"));
			status.setData(countOfEmployeeByDepartmentList);
		}else {
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
			status.setData(countOfEmployeeByDepartmentList);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
			status.setData(null);
		}
		
		return status;
	}
	
	public Status getCountOfEmployeeByRole() {
		
		Status status = new Status();
		
		List<CountOfEmployeeByDepartment> countOfEmployeeByRoleList = dashboardDao.getCountOfEmployeeByRole();
		
		try {
		if(countOfEmployeeByRoleList.size()>0) {
			status.setCode(1);
			status.setMessage(messageService.getMessageNameByCode("FETCHED_SUCCESSFULLY"));
			status.setData(countOfEmployeeByRoleList);
		}else {
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
			status.setData(countOfEmployeeByRoleList);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
			status.setData(null);
		}
		
		return status;
	}

}
