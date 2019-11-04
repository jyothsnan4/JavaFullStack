package com.university.hib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student3")
public class Student2 implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="studentno")
	private int studentno;
    private String name;
    private String department;
  //For Uni-directional mapping - we fetch from Employee email details - from email we cannot fetch employee details
  	 //@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL)
  	// @JoinColumn(name="emp_mailid")  // for preventing creation of extra  join table which stores the relation in case of uni-directional relationship
  	    // equivalent of a Foreign key column in db terminology
    //Join column only in source class
    
    //bidirectional mapping
    @OneToMany(orphanRemoval=true, cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="stud")  
   // @JoinColumn(name="stud_id") //can alternatively use either mapped by or join column 
    private List<Email2> list=new ArrayList<Email2>();
    
	public List<Email2> getList() {
		return list;
	}
	public void setList(List<Email2> list) {
		this.list = list;
	}
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
