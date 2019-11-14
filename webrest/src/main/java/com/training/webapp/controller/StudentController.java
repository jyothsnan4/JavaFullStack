package com.training.webapp.controller;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.training.webapp.model.Student;
import com.training.webapp.repositories.StudentRepo;

@Controller
@RequestMapping("/university")
public class StudentController {

	//@Autowired
	StudentRepo repo;  //Autowired annotaion makes it see as contructor dependency and unlike in spring you dont have to mention in any xml file. 
	                    //Boot takes care of it and meet that dependency. All the stereotypes are autoconfigured automatically. No need for autowire
	
	public StudentController(StudentRepo repo){ 
		this.repo=repo;
	}
	
	@GetMapping("/addStudent")
	public String sendForm(Student student){
		return "addStudent";
	}
	@PostMapping("/addStudent1")
	public ResponseEntity<Student> processForm(@RequestParam(name="name") String name, @RequestParam(name="department") String department, Student student)
	{
		student.setName(name);
		student.setDepartment(department);
		repo.save(student);
		student=repo.getOne(student.getStudentno());
		return ResponseEntity.ok(student);
	}
}
