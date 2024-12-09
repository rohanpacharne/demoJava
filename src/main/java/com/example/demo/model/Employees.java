package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

import com.example.demo.enum1.EmployeeStatus;
import com.example.demo.enum1.Priority;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Employees")
public class Employees {
	
	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "SALARY")
	private int salary;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "MOBILE")
	private Long mobile;
	
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "EMPLOYEE_CODE")
	private String employeeCode;
	
	@Column(name = "HIRE_DATE")
	private LocalDate hireDate;
	
	@Transient
	private String departmentName;
	
	@Transient
	private String roleName;
	
	@Transient
	private String valueCode;
	
	@Transient
	private String valueName;
	
	

	public Employees() {
		super();
	}

	

	public Employees(Long employeeId, String firstName, String middleName, String lastName, int salary, String email,
			Long mobile, Long departmentId, Long roleId, String status, String employeeCode, LocalDate hireDate,
			String departmentName, String roleName, String valueCode, String valueName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.salary = salary;
		this.email = email;
		this.mobile = mobile;
		this.departmentId = departmentId;
		this.roleId = roleId;
		this.status = status;
		this.employeeCode = employeeCode;
		this.hireDate = hireDate;
		this.departmentName = departmentName;
		this.roleName = roleName;
		this.valueCode = valueCode;
		this.valueName = valueName;
	}



	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getEmployeeCode() {
		return employeeCode;
	}



	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	



	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	

	public String getValueCode() {
		return valueCode;
	}



	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}



	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}



	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", salary=" + salary + ", email=" + email + ", mobile=" + mobile
				+ ", departmentId=" + departmentId + ", roleId=" + roleId + ", status=" + status + ", employeeCode="
				+ employeeCode + ", hireDate=" + hireDate + ", departmentName=" + departmentName + ", roleName="
				+ roleName + ", valueCode=" + valueCode + ", valueName=" + valueName + "]";
	}

	

	




	
	

}
