package com.user.impl.repository;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.impl.entity.User;
import com.user.impl.entity.UserExamEntity;

@Repository
public interface UserExamRepository extends CrudRepository<UserExamEntity,Long> {

	@Query(value = "select userExamID from UserExamEntity u")
	ArrayList<Integer> getUserExamID();
	
}
