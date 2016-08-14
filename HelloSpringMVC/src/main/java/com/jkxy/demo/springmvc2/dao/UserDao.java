package com.jkxy.demo.springmvc2.dao;

import org.springframework.stereotype.Repository;

import com.jkxy.demo.springmvc.bean.User;

@Repository
public class UserDao {

	public User selectByUsername(String username) {
		
		// admin
		if ("admin".equals(username)) {
			User user = new User();
			user.setPassword("123");
			user.setUsername("admin");
			return user;
		}
		
		return null;
	}

}
