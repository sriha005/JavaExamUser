package com.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
		System.out.println( "Hello World!" );
	}

}