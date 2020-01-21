package com.user.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.domain.UserDomain;
import com.user.impl.entity.User;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/user")
public interface UserServiceInterface {

	@PostMapping(path="/") // Map ONLY POST Requests
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public @ResponseBody Object addNewUser (@RequestBody UserDomain c);
	
	@PutMapping(path="/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public @ResponseBody Object updateUser (@RequestBody UserDomain c);
	
	@GetMapping(path="/")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody Iterable<User> getAllUsers();
	
	@GetMapping(path="/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("/all")
	public @ResponseBody User findById(@PathVariable("id") int Id);
}
