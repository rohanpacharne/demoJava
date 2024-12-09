package com.example.demo.model;

import com.example.demo.enum1.Priority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {
	
	@Id
	@Column(name = "TASK_ID")
	private int id;
	
	@Column(name = "TASK_NAME")
	private String taskName;
	
	@Column(name = "PRIORITY")
	private Priority priority;
	
	public Task() {
		
	}
	
	public Task(String taskName, Priority priority) {
		this.taskName = taskName;
		this.priority = priority;
	}
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	
	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", priority=" + priority + "]";
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Task task1 = new Task("Task 1",Priority.LOW);
//		System.out.println(task1);
//		
//	}

}
