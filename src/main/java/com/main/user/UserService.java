package com.main.user;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller    // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserService {
	@Autowired
	private UserDao userRepository;
	
	@PostMapping(path="/") // Map ONLY POST Requests
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public @ResponseBody String addNewUser (@RequestBody User c) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		 //Customer c = new Customer(name,product_id);
		
		
		userRepository.save(c);
		return "Saved";
		
	}
	
	@PutMapping(path="/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public @ResponseBody String updateUser (@RequestBody User c) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		userRepository.save(c);
		return "Saved";
		
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
	
}
