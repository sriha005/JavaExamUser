package com.user.impl.validator;



import com.user.domain.UserDomain;
import com.user.impl.entity.User;

import java.lang.reflect.*;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;


public class Validator {

	public static Object validate(UserDomain u) throws UserException {
		String s = null;
		Client client = ClientBuilder.newClient();
		String REST_URI = "http://localhost:8082/user/checkUsername";
		GenericType<User> list = new GenericType<User>() {};
		Response response = client
	      .target(REST_URI)
	        .request(MediaType.APPLICATION_JSON)
	         .post(Entity.entity(u,MediaType.APPLICATION_JSON));
		
		UserDomain user = response.readEntity(UserDomain.class);
		
		try {
			if(!u.checkNullField().equals("gucci")) {
				
				s =  "400 " + u.checkNullField() + " is null";
				throw new UserException("400 " + u.checkNullField() + " is null");
				
			}
			if(u.getFirstname().length()>100) {
				s="400 firstname is >100 characters";
				throw new UserException("400 firstname is >100 characters");
			}
			else if(u.getLastname().length()>100) {
				s = "400 lastname is >100 characters";
				throw new UserException("400 lastname is >100 characters");
			}
			else if(u.getUsername().length()>10) {
				s="400 username is >10 characters";
				throw new UserException("400 username is >10 characters");
			}
			else if(u.getPassword().length()>16) {
				s="400 password is >16 characters";
				throw new UserException("400 password is >16 characters");
			}
			else if(user!=null) {
				s="400 username in use, please select another";
				throw new UserException("400 username in use, please select another");
			}
			else if(!StringUtils.isAlphanumeric(u.getUsername())){
				s="400 username has special characters";
				throw new UserException(s);
			}
			
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(s!=null) {
				return s;
			}
			else {
				return "200 success";
			}
		}
		
		
		
		
		
	//	return u;
		
	}
	public static boolean stringTest(Object any)
	{  
	   return any instanceof String;

	}
	public static void main(String args[]){ 
		UserDomain u = new UserDomain("U","k","k@","jugddgd");
		Object a = null;
		//u.setUserID(7);
		try {
			a = validate(u);
			System.out.println("hyhy");
		} catch (Exception m){System.out.println("Exception occured: "+m);}
		finally {
			System.out.println(a);
		}
		System.out.println(stringTest(a));
	}
	
}
