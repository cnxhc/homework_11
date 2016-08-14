package com.jkxy.demo.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jkxy.demo.springmvc.bean.User;
import com.jkxy.demo.springmvc.constant.Global;
import com.jkxy.demo.springmvc.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	@Resource
	UserService service;
	
	@RequestMapping("login")
	public String toLoginPage(){
		return "/WEB-INF/jsp/login.jsp";
	}
	
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin(@RequestParam String username , @RequestParam String password, HttpServletRequest request, ModelMap map ){
		
		try {
			User user = service.doLogin(username, password); 
			request.getSession().setAttribute("user", user);
			map.put("user",user);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			return "/WEB-INF/jsp/error.jsp";
		}
		
		return "/WEB-INF/jsp/message.jsp";
		
	}
	
	@RequestMapping("doLogout")
	public String doLogout(SessionStatus status){
		status.setComplete();
		return "/index.jsp";
	}
	
}
