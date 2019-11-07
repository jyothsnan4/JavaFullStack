package com.university.hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestManyToMany {
@SuppressWarnings("unchecked")
public static void main(String args[]){
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction trans=session.beginTransaction();
	Student4 stud1=new Student4();
	stud1.setName("Jyothsna");
	stud1.setDepartment("Computer Science");
	
	Student4 stud2=new Student4();
	stud2.setName("Gokul");
	stud2.setDepartment("Electronics");
	
	Course course1 = new Course();
	course1.setCourse_name("data structures");
	
	Course course2 = new Course();
	course2.setCourse_name("database");
	
	Course course4 = new Course();
	course4.setCourse_name("Semiconductor");
	
	Course course5 = new Course();
	course5.setCourse_name("Packaging");
	
	Course course6 = new Course();
	course6.setCourse_name("ASIC");
	
	
	List<Student4> list_comp=new ArrayList<Student4>();
	List<Student4> list_elec=new ArrayList<Student4>();
	
	list_comp.add(stud1);
	list_elec.add(stud2);
	
	List<Course> course_comp=new ArrayList<Course>();
	List<Course> course_elec=new ArrayList<Course>();
	
	course_comp.add(course1);
	course_comp.add(course2);
	course_elec.add(course4);
	course_elec.add(course5); 
	stud1.setCourse(course_comp);
	stud2.setCourse(course_elec);
	course1.setStud(list_comp);
	course2.setStud(list_comp);
	course4.setStud(list_elec);
	course5.setStud(list_elec);
	
	/*session.save(course1);
	session.save(course2);
	session.save(course4);
	session.save(course5);
	session.save(course6);*/ //not needed as we are using cascade
	session.persist(stud1);
	session.persist(stud2);
	
	
	trans.commit();
	
	//https://www.codejava.net/frameworks/hibernate/hibernate-query-language-hql-example. Go through steps
	//Queries HQL
	//1.
	Student4 stud = (Student4)session.get(Student4.class, 2);
	System.out.println("Name of Student is:"+stud.getName());
	
	//2. 
	Student4 student=(Student4)session.load(Student4.class, 1);
	System.out.println(student.getName()+" is in this department:"+student.getDepartment());
	
	//3. List Query 
	String hql="from Student4"; //can omit select in HQL.
	Query query=session.createQuery(hql);
	List<Student4> student_list=query.list();
	for(Student4 stud4:student_list)
		System.out.println(stud4.getName());
	
	
	
	
		
	
	
	
	
	session.close();
	sf.close();
	
	
}
}
