package com.training.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.webapp.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{     //<classname,primary_key_data_type>
//gives repo object access to infinite functions/methods. 
	//no code here
	//controller cannot access DB diectly, so accountrepo required in controller. 
}
