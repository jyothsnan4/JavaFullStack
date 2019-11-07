package com.university.hib;

import java.io.Serializable;
//import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="student4")
public class Student4 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="studentno")
	private int studentno;
    private String name;
    private String department;
    //for Unidirectional,no mapping in targetclass
    // @ManyToMany(targetEntity=Item.class, cascade=CascadeType.ALL)
	 //@JoinTable( name="cart_items",
             //joinColumns={ @JoinColumn(name="fkcart_id")},
      //       inverseJoinColumns={ @JoinColumn(name="fkitem_id")}
	 //)
    
    //BiDirectional
    @ManyToMany(targetEntity=Course.class, cascade=CascadeType.ALL, mappedBy="stud")
    /*@JoinTable(name="student_course",
                 joinColumns={@JoinColumn(name="fk_id")},
                 inverseJoinColumns={@JoinColumn(name="fk_studentno")})*/
    private List<Course> course = new ArrayList<Course>();

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

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
    
    
    
    
}
