package com.example.demo.model;

public class CountOfEmployeeByDepartment {
	
	private String departmentName;
	private int countByDepartment;
	private String roleName;
	private int countByRole;
	public CountOfEmployeeByDepartment() {
		super();
	}
	
	public CountOfEmployeeByDepartment(String departmentName, int countByDepartment, String roleName, int countByRole) {
		super();
		this.departmentName = departmentName;
		this.countByDepartment = countByDepartment;
		this.roleName = roleName;
		this.countByRole = countByRole;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public int getCountByDepartment() {
		return countByDepartment;
	}

	public void setCountByDepartment(int countByDepartment) {
		this.countByDepartment = countByDepartment;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getCountByRole() {
		return countByRole;
	}

	public void setCountByRole(int countByRole) {
		this.countByRole = countByRole;
	}

	@Override
	public String toString() {
		return "CountOfEmployeeByDepartment [departmentName=" + departmentName + ", countByDepartment="
				+ countByDepartment + ", roleName=" + roleName + ", countByRole=" + countByRole + "]";
	}

	
}
