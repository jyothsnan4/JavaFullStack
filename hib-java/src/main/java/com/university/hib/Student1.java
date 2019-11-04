package com.university.hib;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="student2")
public class Student1 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="studentno")
    private int studentno;
    private String name;
    private String department;
    
    
 // @OneToOne(cascade = CascadeType.ALL) Unidirectional. Source holds foreign key
  //@JoinColumn(name="det_id")
  //private Detail detail;
//In unidirectional association, source entity has a field that refers to 
    //the target entity and the source entity’s table contains the foreign key.
    //To define a one-to-one bidirectional association, the @OneToOne annotation with join column must be used in the target entity 
   //and the mappedBy attribute must be used in the source entity 

    @OneToOne(mappedBy="stud",cascade=CascadeType.ALL,fetch=FetchType.LAZY) //stud refers to the object of same class defined in other class
    private Details d;
    
	public Details getD() {
		return d;
	}
	public void setD(Details d) {
		this.d = d;
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
