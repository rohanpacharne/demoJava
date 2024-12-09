package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Departments {
	
	@Id
	@Column(name = "DEPARTMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name = "DEPARTMENT_DESC")
	private String departmentDesc;

	public Departments() {
		super();
	}

	public Departments(Long departmentId, String departmentName, String departmentDesc) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentDesc = departmentDesc;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartment_id(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	@Override
	public String toString() {
		return "Departments [department_id=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentDesc=" + departmentDesc + "]";
	}
	
	

}
