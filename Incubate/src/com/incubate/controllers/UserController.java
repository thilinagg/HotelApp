package com.incubate.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.incubate.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		String ses = String.valueOf(httpSession.getAttribute("login"));
		if (ses != null) {
			return new ModelAndView("hotel");
		}
		else {
			return new ModelAndView("login").addObject("error", "Username or password incorrect");
		}
		
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView viewHome(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		System.out.println(username);
		System.out.println(password);
		boolean loginSuccess = userService.login(username, password);
		if (loginSuccess) {
			httpSession.setAttribute("login", username);
			httpSession.setMaxInactiveInterval(7*60);
			return new ModelAndView("hotel");
		}
		else {
			return new ModelAndView("redirect:/login");
		}
		
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView viewHome2() {
		String ses = String.valueOf(httpSession.getAttribute("login"));
		System.out.println(ses.equals(null));
		if (ses.equals("null")) {
			return new ModelAndView("login");
			
		}
		else {
			return new ModelAndView("hotel");
		}
		
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signout(HttpServletResponse httpServletResponse) {
		httpSession.invalidate();
		return new ModelAndView("login");
		
	}
	

	

}
