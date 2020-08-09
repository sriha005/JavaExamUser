package com.user.impl;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.impl.entity.UserExamEntity;
import com.user.impl.repository.UserExamRepository;



@RestController
@RequestMapping(value="/userexam")
public class UserExamImpl {

	@Autowired
	UserExamRepository ueRepository;

	@CrossOrigin(origins = {"http://192.168.0.165:4201","http://localhost:4201","https://test-6780f.firebaseapp.com"})
	@PostMapping(path="/")
	public @ResponseBody UserExamEntity addExam(@RequestBody UserExamEntity e ){
		// This returns a JSON or XML with the users
		ueRepository.save(e);
		return e;
	}
	
	
	@GetMapping(path="/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody Iterable<UserExamEntity> getUserExam(){
		// This returns a JSON or XML with the users
		
		
		return ueRepository.findAll();
	}
	
	@CrossOrigin(origins = {"http://192.168.0.165:4201","http://localhost:4201","https://test-6780f.firebaseapp.com"})
	@GetMapping(path="/id")
	public @ResponseBody int getUserExamID() {
		ArrayList<Integer> id = ueRepository.getUserExamID();
		for(int i = 0; i<id.size();i++)
		{
			if(!id.contains(i)) {
				return i;
			}
		}
		return id.size();
	}
}
