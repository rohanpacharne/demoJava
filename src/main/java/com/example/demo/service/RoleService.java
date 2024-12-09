package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.model.Roles;
import com.example.demo.model.Status;

@Service
public class RoleService {
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	MessageService messageService;
	
	public Status getAllRoles() {
		
		Status status = new Status();
		
		List<Roles> rolesList = roleDao.getAllRoles();
		
		try {
		if(rolesList.size()>0) {
			status.setCode(1);
			status.setMessage(messageService.getMessageNameByCode("FETCHED_SUCCESSFULLY"));
			status.setData(rolesList);
		}else {
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
			status.setData(rolesList);
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
