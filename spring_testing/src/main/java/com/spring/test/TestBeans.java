//File corrupted because of multiple git push and get. But logic is right. created for git. don't refer.

package com.spring.test;
import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
//main() class and values for objects are provided and BeanFactory is also declared. 
//Ensure version numbers are same for core and context. 
public class TestBeans {
public static void main(String args[]) throws SQLException{
	BeanFactory factory=new XmlBeanFactory(
		new FileSystemResource("/Users/jyothsnagokul/Documents/JavaFullStack2/spring_testing/src/main/java/beans.xml"));
	Object obj=factory.getBean("persist"); //lazy loading
	PerformPersistence p=(PerformPersistence) obj;
	Student stud = (Student) factory.getBean("stud");
	stud.setStudentno(1);
	stud.setName("Jyothsna");
	stud.setDepartment("Computer Science");
	p.save(stud);
}
}
