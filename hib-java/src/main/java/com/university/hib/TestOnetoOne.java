package com.university.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestOnetoOne {
public static void main(String args[]){
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction trans=session.beginTransaction();
	Student1 stud1=new Student1();
	stud1.setName("Jyothsna");
	stud1.setDepartment("ComputerScience");
	
	Details d1=new Details();
	d1.setSsn(2001);
	d1.setDate_of_birth("01-20-1991");
	d1.setAddress("23 TanOak Dr Hayward CA");
	d1.setStud(stud1);
	
	stud1.setD(d1);
	
	session.persist(stud1);
     
	trans.commit();
	}
}
