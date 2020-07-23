package com.dev.jpa.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

	@RequestMapping(value={"", "/"})
	public String mainView(HttpServletRequest req, HttpServletResponse res, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("auth------------ "+auth.getName());
		if(auth.getName().equals("anonymousUser")){
			return "/main/mainWeb";
		}
		HttpSession session = req.getSession();
		User user = (User)auth.getPrincipal();
		session.setAttribute("user", user);		
		return "/main/mainWeb";
	}
}
