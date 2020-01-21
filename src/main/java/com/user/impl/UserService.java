package com.user.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.domain.UserDomain;
import com.user.impl.entity.User;
import com.user.impl.repository.UserDao;
import com.user.impl.transformer.UserTransformer;
import com.user.impl.validator.Validator;
import com.user.service.UserServiceInterface;


//use xml root element for xml conversion good for json
@Controller    // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserService implements UserServiceInterface {
	@Autowired
	private UserDao userRepository;
	
	@CrossOrigin(origins = "http://localhost:4201")
	@PostMapping(path="/") // Map ONLY POST Requests
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public @ResponseBody Map addNewUser (@RequestBody UserDomain c) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		 //Customer c = new Customer(name,product_id);
		
		//validate user
		//all fields mandatory
		//limit to 100 characters
		//username only max 10 no special characters
		//pass 16 characters max
		// as best practice use to sql injection or fields not suppposed to be saved, create
		//new User to push to database if validation is passed(domain to entity conversion)
		//return user domain in case front end needs it like id of object for instance
		//create separate user classes fro entity and domain
		//for fail return "400 whatever reason"
		//use excdeption in va;idate class for validation. Separate exception class from validqtion)
		
		Object a = null;
		//u.setUserID(7);
		try {
			a = Validator.validate(c);
			
		} catch (Exception m){System.out.println("Exception occured: "+m);}
		finally {
			//System.out.println(a);
		}
		/*
		if(Validator.stringTest(a)) {
			return a;
		}*/
		if(a != "200 success") {
			return Collections.singletonMap("response", a);
		}
		User u = UserTransformer.domainToEntity(c);
		
		userRepository.save(u);
		return Collections.singletonMap("response", a);
		
	}
	
	@PutMapping(path="/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public @ResponseBody Object updateUser (@RequestBody UserDomain c) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Object a = null;
		//u.setUserID(7);
		try {
			a = Validator.validate(c);
			
		} catch (Exception m){System.out.println("Exception occured: "+m);}
		finally {
			//System.out.println(a);
		}
		if(Validator.stringTest(a)) {
			return a;
		}
		User u = new User(c.getUserID(),c.getFirstname(),c.getLastname(),c.getUsername(),c.getPassword());
		userRepository.save(u);
		return a;
		
	}
	
	@GetMapping(path="/")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody User findById(@PathVariable("id") int Id){
		// This returns a JSON or XML with the users
		return userRepository.findById(Id);
	}
	
	@CrossOrigin(origins = "http://localhost:4201")
	@PostMapping(path="/login")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody User verifyUser(@RequestBody User user){
		// This returns a JSON or XML with the users
		
		System.out.println(user.getUsername() + " " + user.getPassword());
		return userRepository.verifyUser(user.getUsername(),user.getPassword());
	}
	
	
	@PostMapping(path="/checkUsername")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	//@Path("/all")
	public @ResponseBody User verifyUsername(@RequestBody User user){
		// This returns a JSON or XML with the users
		
		System.out.println(user.getUsername());
		return userRepository.verifyUsername(user.getUsername());
	}
	
}
