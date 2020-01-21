package com.user.impl.repository;

import org.springframework.stereotype.Repository;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.annotation.Transactional;

import com.user.impl.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
	
	@Query(value = "select p from User p where p.userID = :userID")
	User findById(@Param("userID") int userID);
	
	@Query(value = "select p from User p where p.username = :username and p.password = :password")
	User verifyUser(@Param("username") String username, @Param("password") String password);
	
	@Query(value = "select p from User p where p.username = :username")
	User verifyUsername(@Param("username") String username);
	
	@Transactional
	@Modifying
	@Query("delete from User p WHERE p.userID = :userID")
	void deleteById(@Param("userID") int userID);
	
	void deleteAll();
}