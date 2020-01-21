package com.user.impl.transformer;

import com.user.domain.UserDomain;
import com.user.impl.entity.User;

public class UserTransformer {
	public static User domainToEntity(UserDomain c) {
		
		User u = new User(c.getUserID(),c.getFirstname(),c.getLastname(),c.getUsername(),c.getPassword());
		return u;
	}
}
