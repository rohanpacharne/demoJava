package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.LoginDao;
import com.example.demo.model.Employees;
import com.example.demo.model.Status;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	MessageService messageService;
	
	public Status getLoginDetails(String email) {
		Status status = new Status();
		Map<String,Object> details = new HashMap<String,Object>();
		try {
			Employees employees = loginDao.getLoginDetails(email);
			if(employees!=null) {
				if(employees.getStatus().equals("ACTIVE")) {
					status.setCode(1);
					status.setMessage("Login successful for "+employees.getEmail());
					details.put("employeeCode", employees.getEmployeeCode());
					details.put("role", employeeDao.getRoleNameById(employees.getRoleId()));
					details.put("department", employeeDao.getDepartmentNameById(employees.getDepartmentId()));
					details.put("status", employees.getStatus());
					status.setData(details);
				}else {
					status.setCode(0);
					status.setMessage(employees.getEmail()+" is inactive");
//					details.put("employeeCode", employees.getEmployeeCode());
//					details.put("role", employeeDao.getRoleNameById(employees.getRoleId()));
//					details.put("department", employeeDao.getDepartmentNameById(employees.getDepartmentId()));
//					details.put("status", employees.getStatus());
					status.setData(details);
				}
			}else {
				status.setCode(0);
				status.setMessage("Login unsuccessful for "+employees.getEmail());
//				details.put("employeeCode", employees.getEmployeeCode());
//				details.put("role", employeeDao.getRoleNameById(employees.getRoleId()));
//				details.put("department", employeeDao.getDepartmentNameById(employees.getDepartmentId()));
//				details.put("status", employees.getStatus());
				status.setData(details);
			}
		}catch(Exception ex) {
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
//			details.put("employeeCode", employees.getEmployeeCode());
//			details.put("role", employeeDao.getRoleNameById(employees.getRoleId()));
//			details.put("department", employeeDao.getDepartmentNameById(employees.getDepartmentId()));
//			details.put("status", employees.getStatus());
			status.setData(details);
		}
		return status;
	}
	

}
