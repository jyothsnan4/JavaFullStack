package com.project.changepass.change_password.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.changepass.change_password.model.ChangePass;

public interface ChangePassRepo extends JpaRepository<ChangePass, Integer> {

	//return record where username is this. 
	@Query("SELECT c FROM ChangePass AS c WHERE c.username = :username") //* for all doesnt work. use c. 
	ChangePass findByUsername(@Param("username") String username); //returns Object after companring with username. 
    
	//update new password where username is this. 
	@Modifying
	@Transactional
	@Query("UPDATE ChangePass c set c.new_pass=:new_pass where c.username=:username")
	 Integer saveByUsername(@Param("username") String username, @Param("new_pass") String new_pass);
	
}
