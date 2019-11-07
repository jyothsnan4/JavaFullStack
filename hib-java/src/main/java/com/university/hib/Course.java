package com.university.hib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int course_id;
    private  String course_name;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="student_course",
                 joinColumns={@JoinColumn(name="fk_id")},
                 inverseJoinColumns={@JoinColumn(name="fk_studentno")}) //order is important. join column same table id & inverse join column other table id
    private List<Student4> stud = new ArrayList<Student4>();

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public List<Student4> getStud() {
		return stud;
	}

	public void setStud(List<Student4> stud1) {
		this.stud = stud1;
	}

	
    
                 
    
}
