package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Departments;
import com.example.demo.model.Employees;
import com.example.demo.model.Pagination;
import com.example.demo.model.Status;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentDao departmentDao;
	
	@Autowired
	MessageService messageService;
	
	public Pagination getDepartmentsDatatable(int page, int size) {
		Pagination pagination = new Pagination();
		
		 if (page <= 0 || size <=0) {
	           // throw new IllegalArgumentException("Page size must be greater than zero.");
			 pagination.setData("The page and size can not be zero");
			 return pagination;
	        }
		
		
		try {
			List<Departments> departmentsList = departmentDao.getDepartmentsDatatable((page-1),size);
			int count = departmentsList.size();
			if(departmentsList.size()>0) {
				pagination.setCount(count);
				pagination.setTotalCount(departmentDao.getAllDepartmentsCount());
				pagination.setTotalPages((int) Math.ceil((double) departmentDao.getAllDepartmentsCount() / size));
				pagination.setData(departmentsList);
				pagination.setPage(page);
				pagination.setSize(size);
			}else {
				pagination.setCount(count);
				pagination.setTotalCount(departmentDao.getAllDepartmentsCount());
				pagination.setTotalPages((int) Math.ceil((double) departmentDao.getAllDepartmentsCount() / size));
				pagination.setData(departmentsList);
				pagination.setPage(page);
				pagination.setSize(size);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			pagination.setCount(0);
			pagination.setTotalCount(0);
			pagination.setTotalPages((int) Math.ceil((double) departmentDao.getAllDepartmentsCount() / size));
			pagination.setData(null);
			pagination.setPage(page);
			pagination.setSize(size);
		}
		
		return pagination;
	}
	
	public Status getAllDepartments() {
		Status status = new Status();
		
		try {
			List<Departments> departmentsList = departmentDao.getAllDepartments();
			if(departmentsList.size()>0) {
				status.setCode(1);
				status.setMessage(messageService.getMessageNameByCode("FETCHED_SUCCESSFULLY"));
				status.setData(departmentsList);
			}else {
				status.setCode(0);
				status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
				status.setData(departmentsList);
			}
		}catch(Exception ex) {
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
			status.setData(null);
		}
		
		return status;
	}

}
