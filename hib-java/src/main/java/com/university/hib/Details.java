package com.university.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Details2")
public class Details implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="det_id")
	private int det_id;
    
	private int ssn;
    private String date_of_birth;
    private String address;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="studentno")
    private Student1 stud;
    
	public Student1 getStud() {
		return stud;
	}
	public void setStud(Student1 stud) {
		this.stud = stud;
	}
	
	public int getDet_id() {
		return det_id;
	}
	public void setDet_id(int det_id) {
		this.det_id = det_id;
	}
	
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
