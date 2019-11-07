package com.university.hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestOnetoMany {
@SuppressWarnings("unchecked")
public static void main(String args[]){
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction trans=session.beginTransaction();
	Student2 stud2=new Student2();
	stud2.setName("Jyothsna");
	stud2.setDepartment("Computer science");
	
	Email2 e1=new Email2();
	e1.setEmail("jyothsnan@gmail.com");
	Email2 e2=new Email2();
	e2.setEmail("jyo@hotmail.com");
	Email2 e3=new Email2();
	e3.setEmail("jo@hotmail.com");
	Email2 e4=new Email2();
	e4.setEmail("jg@yahoo.com");
	List <Email2> list=new ArrayList<Email2>();
	
	list.add(e1);
	list.add(e2);
	list.add(e3);
	list.add(e4);
	
	e1.setStud(stud2);
	e2.setStud(stud2);
	e3.setStud(stud2);
	e4.setStud(stud2);
	stud2.setList(list);
	/*session.save(e1);
	session.save(e2);
	session.save(e3);
	session.save(e4);*/
	session.save(stud2);
	trans.commit();
	
	//HBQL queries: Get EmailIDs from students
	String hql = "FROM Student2 S WHERE S.name='Jyothsna'";
	Query query = session.createQuery(hql);
	List<Student2> studlist = query.list();
	 
	for (Student2 stud : studlist) {
	    System.out.println(stud.getList());
	}
	
	//HBQL queries
	String hql1="From Email2 E WHERE E.email='jg@yahoo.com'";
	Query query1 = session.createQuery(hql1);
	List<Email2> el1 = query1.list();
	 
	for (Email2 x : el1) {
	    System.out.println(x.getStud());
	}
	
	session.close();
	sf.close();
	
}
}
