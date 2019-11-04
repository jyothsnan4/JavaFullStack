package com.university.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Configuration config=new Configuration();//reads cfg.xml file
       config = config.configure();
       SessionFactory sessionfactory=config.buildSessionFactory();
       //used for transactions, jdbc
       Session session=sessionfactory.openSession();//getConnection()
       System.out.println(session.isOpen());//Checking connection
       Transaction trans=session.beginTransaction();
     //1 insert is achieved through save method

       Student stud1=new Student();
       stud1.setName("Jyothsna");
       stud1.setDepartment("Computer Science");
       session.save(stud1);//save in session cache
       
       Student stud2=new Student();
       stud2.setName("Mallika");
       stud2.setDepartment("Computer Science");
       session.save(stud2);//save in session cache
       
       Student stud3=new Student();
       stud3.setName("Balaji");
       stud3.setDepartment("Electronics");
       session.save(stud3);//save in session cache
       
       Student stud4=new Student();
       stud4.setName("Nanda");
       stud4.setDepartment("Materials");
       session.save(stud4);//save in session cache
       trans.commit();//commit to db
       session.close();
       sessionfactory.close();
       
       //There are two methods of fecting data using session.get(classname.class,primry key value) and session.load(classname.class, primarykeyvalue)
       //Update is done by first fetching using get, making changes and then setting again using set. 
       //Then do trans.commit()
       
       	}

}
