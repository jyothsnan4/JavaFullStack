package com.project.changepass.change_password.controller;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
////import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.changepass.change_password.model.ChangePass;
import com.project.changepass.change_password.model.CustomResponse;
import com.project.changepass.change_password.repositories.ChangePassRepo;



@CrossOrigin(origins="*")
@RestController
@RequestMapping({"/passwordchange"})
public class ChangePassController {
 
	@Autowired
	ChangePassRepo repo;
	
	//Contructor Dependency
	public ChangePassController(ChangePassRepo repo){
		this.repo=repo;
		createList();
		
	}
	
	//AddsUsers. 
	private List<ChangePass> createList(){
		List<ChangePass> list = new ArrayList<ChangePass>();
		//Users already in the system. SInce we are trying password change.
		//Since this is the first password ever created. There is no oldpassword. 
		//User1
		ChangePass user1 = new ChangePass();
		user1.setUsername("jyothsna.n");
		user1.setNew_pass("myproject");
		user1.setConfirm_pass("myproject");
		user1.setConfirm_pass("N/A");
		user1.setOld_pass("N/A");
		list.add(user1);
	   
		//user 2
		ChangePass user2 = new ChangePass();
		user2.setUsername("geetha.n");
		user2.setNew_pass("myhappiness");
		user2.setConfirm_pass("myhappiness");
		user2.setConfirm_pass("N/A");
		user2.setOld_pass("N/A");
		list.add(user2);
		
		//User3
		ChangePass user3 = new ChangePass();
		user3.setUsername("jayitha.gokul");
		user3.setNew_pass("ilovemom");
		user3.setConfirm_pass("N/A");
		user3.setOld_pass("N/A");
		list.add(user3);
		
		//User4
				ChangePass user4 = new ChangePass();
				user4.setUsername("gokul.kum");
				user4.setNew_pass("mybaby");
				user4.setConfirm_pass("N/A");
				user4.setOld_pass("N/A");
				list.add(user4);
				
	     //User5
				ChangePass user5 = new ChangePass();
				user5.setUsername("nat.raj");
				user5.setNew_pass("myjuju");
				user5.setConfirm_pass("N/A");
				user5.setOld_pass("N/A");
				list.add(user5);
		
				repo.saveAll(list);
				System.out.print("Users added to DB.");
				//processForm(user4);
		return list;
	}
	
	
	@PutMapping("/{username}/{oldpass}/{newpass}")
	@Transactional //required in both this and repo method for the update query to work
	public ResponseEntity<CustomResponse> processForm(@PathVariable("username") String username,@PathVariable("oldpass") String old_pass,@PathVariable("newpass") String new_pass )
	{
		
		ChangePass user1;
		String response;
		System.out.println("the new pass is:"+new_pass);
		user1 = repo.findByUsername(username);
		if(user1.getNew_pass().equals(old_pass)){
		System.out.println("the usernumber is:"+user1.getNumber());
		user1.setNew_pass(new_pass);
		System.out.println("new password is:"+user1.getNew_pass());
		repo.saveByUsername(user1.getUsername(), user1.getNew_pass());
		response="Password updated successfully";
        CustomResponse res=new CustomResponse();
        res.setStatus(response);
		return ResponseEntity.ok(res);
		}
		else{
			response="Existing password incorrect. Pls verify.";
			CustomResponse res2=new CustomResponse();
	        res2.setStatus(response);
			return ResponseEntity.ok(res2);
		}
		
	}
		
	
	
	
}