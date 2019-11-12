package com.spring.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//saves object to db. used to perform db operations. . 
public class PerformPersistence {
//we dont use new operator. Instead use constructor for instantiating. 
	ConnectionSource source; //we dont write = new ConnectionSource in Spring. Instead we use the constructor. 
	PerformPersistence(ConnectionSource source){
		System.out.print("Calling contructor...");
		this.source=source;
	}
	
	//saving using jdbc instead of hibernate
	@SuppressWarnings("static-access")
	public void save(Student stud) throws SQLException{
		//connect to db
		Connection con=source.connect();
		//push to db
		PreparedStatement ps = con.prepareStatement("insert into Stud values(?,?,?)");
		ps.setInt(1, stud.getStudentno());
        ps.setString(2,stud.getName());
        ps.setString(3,stud.getDepartment());
        int count = ps.executeUpdate();
        System.out.println((count > 0 )? "one record is inserted":"zero records inserted" );

		
	}
}
