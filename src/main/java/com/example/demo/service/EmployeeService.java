package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employees;
import com.example.demo.model.Pagination;
import com.example.demo.model.Status;
import com.example.demo.repository.EmployeeRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
    EmployeeRepository employeeRepository;
	
	@Autowired
	MessageService messageService;
	
	 public Page<Employees> getEmployees(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        Page p = employeeRepository.findAll(pageable);
	        System.out.println(p);
	        return p;
	    }
	
	public Pagination getAllEmployees(int page, int size) {
		Pagination pagination = new Pagination();
		
		 if (page <= 0 || size <=0) {
	           // throw new IllegalArgumentException("Page size must be greater than zero.");
			 pagination.setData("The page and size can not be zero");
			 return pagination;
	        }
		
		
		try {
			List<Employees> employeesList = employeeDao.getAllEmployees((page-1),size);
			int count = employeesList.size();
			if(employeesList.size()>0) {
				pagination.setCount(count);
				pagination.setTotalCount(employeeDao.getAllEmployeesCount());
				pagination.setTotalPages((int) Math.ceil((double) employeeDao.getAllEmployeesCount() / size));
				pagination.setData(employeesList);
				pagination.setPage(page);
				pagination.setSize(size);
			}else {
				pagination.setCount(count);
				pagination.setTotalCount(employeeDao.getAllEmployeesCount());
				pagination.setTotalPages((int) Math.ceil((double) employeeDao.getAllEmployeesCount() / size));
				pagination.setData(employeesList);
				pagination.setPage(page);
				pagination.setSize(size);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			pagination.setCount(0);
			pagination.setTotalCount(0);
			pagination.setTotalPages((int) Math.ceil((double) employeeDao.getAllEmployeesCount() / size));
			pagination.setData(null);
			pagination.setPage(page);
			pagination.setSize(size);
		}
		
		return pagination;
	}
	
	public Status update(Employees employees) {
		Status status = new Status();
		
		String checkNull = checkNull(employees);
		
		if(checkNull.equals("null")) {
			
			status.setCode(0);
			status.setMessage("Please enter first name, last name, hire date, department and role");
			status.setData(null);
			
			return status;
		}
		try {
			Employees newEmployees = employeeDao.update(employees);
			if(newEmployees!=null) {
				status.setCode(1);
				status.setMessage(messageService.getMessageNameByCode("UPDATED_SUCCESSFULLY"));
				status.setData(employeeDao.getEmployeeById(newEmployees.getEmployeeId()));
			}else {
				status.setCode(0);
				status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
				status.setData(newEmployees);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
			status.setData(null);
		}
		
		return status;
	}
	
	public Status save(Employees employees) {
		
		Status status = new Status();
		
		String checkNull = checkNull(employees);
		
		if(checkNull.equals("null")) {
			
			status.setCode(0);
			status.setMessage("Please enter first name, last name, hire date, department and role");
			status.setData(null);
			
			return status;
		}
		
		try {
			Employees newEmployees = employeeDao.save(employees);
			if(newEmployees!=null) {
				status.setCode(1);
				status.setMessage(messageService.getMessageNameByCode("INSERTED_SUCCESSFULLY"));
				status.setData(employeeDao.getEmployeeById(newEmployees.getEmployeeId()));
			}else {
				status.setCode(0);
				status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
				status.setData(newEmployees);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
			status.setData(null);
		}
		
		return status;
	}
	
	public Status delete(Long employeeId) {
		Status status = new Status();
		try {
			boolean isDeleted = employeeDao.delete(employeeId);
			if(isDeleted) {
				status.setCode(1);
				status.setMessage(messageService.getMessageNameByCode("DELETED_SUCCESSFULLY"));
				status.setData(null);
			}else {
				status.setCode(0);
				status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
				status.setData(null);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
			status.setData(null);
		}
		
		return status;
	}
	
	public Status getEmployeeById(Long employeeId) {
		Status status = new Status();
		try {
			Employees employee = employeeDao.getEmployeeById(employeeId);
			if(employee!=null) {
				status.setCode(1);
				status.setMessage(messageService.getMessageNameByCode("FETCHED_SUCCESSFULLY"));
				status.setData(employee);
			}else {
				status.setCode(0);
				status.setMessage(messageService.getMessageNameByCode("DATA_NOT_FOUND"));
				status.setData(null);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage(messageService.getMessageNameByCode("ERROR"));
			status.setData(null);
		}
		
		return status;
	}
	
	public String checkNull(Employees employees) {
		
		if(employees.getFirstName()==null || employees.getLastName()==null ||
				employees.getFirstName().equals("") || employees.getLastName().equals("") ||
				employees.getHireDate()==null || employees.getHireDate().equals("") || employees.getRoleId()==null ||
				employees.getDepartmentId()==null) 
		{
			return "null";
		}
		
		return "notnull";
	}

}
