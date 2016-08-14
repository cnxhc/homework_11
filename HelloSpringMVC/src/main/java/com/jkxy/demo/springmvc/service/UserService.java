package com.jkxy.demo.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jkxy.demo.springmvc.bean.User;
import com.jkxy.demo.springmvc2.dao.UserDao;

@Service
public class UserService {

	@Resource
	UserDao dao ;

	public User doLogin(String username, String passwrod) throws Exception {
		
		if (username == null || "".equals(username)) {
			throw new Exception("用户名不能为空");
		}
		if (passwrod == null || "".equals(passwrod)) {
			throw new Exception("密码不能为空");
		}		
		
		User user = dao.selectByUsername(username);
		if (user == null) {
			throw new Exception("用户名不存在");
		}
		
		if (!user.getPassword().equals(passwrod)) {
			throw new Exception("密码错误");
		}
		
		return user ;
		
	}
	
}
