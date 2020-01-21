package com.user.impl.validator;

public class UserException extends Exception {
	UserException(String s){  
		  super(s);  
		 } 
	
}


class UserException2{  
	  
	   static void validate(int age)throws UserException{  
	     if(age<18)  
	      throw new UserException("not valid");  
	     else  
	      System.out.println("welcome to vote");  
	   }  
	     
	   public static void main(String args[]){  
		   
	      try{  
	      validate(13);  
	      }catch(Exception m){System.out.println("Exception occured: "+m);}  
	  
	      System.out.println("rest of the code...");  
	  }  
	}  