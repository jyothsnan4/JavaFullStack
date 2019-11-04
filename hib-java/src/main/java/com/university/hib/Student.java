package com.university.hib;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
    private int studentno;
    private String name;
    private String department;
    
	public int getStudentno() {
		return studentno;
	}
	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
