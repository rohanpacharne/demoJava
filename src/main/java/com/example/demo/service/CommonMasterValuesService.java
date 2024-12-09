package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommonMasterValuesDao;
import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.CommonMasterValues;
import com.example.demo.model.Departments;
import com.example.demo.model.Status;

@Service
public class CommonMasterValuesService {
	
	@Autowired
	CommonMasterValuesDao commonMasterValuesDao;
	
	@Autowired
	MessageService messageService;
	
	public Status getCommonMasterValuesByName(String masterName) {
		
		Status status = new Status();
		
		List<CommonMasterValues> commonMasterValuesList = commonMasterValuesDao.getCommonMasterValuesByName(masterName);
		
		try {
		if(commonMasterValuesList.size()>0) {
			status.setCode(1);
			status.setMessage(messageService.getMessageNameByCode("FETCHED_SUCCESSFULLY"));
			status.setData(commonMasterValuesList);
		}else {
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
			status.setData(commonMasterValuesList);
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
