package com.dev.jpa.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		User user = (User)auth.getPrincipal();
		System.out.println("user.getUsername()------------" + user.getUsername());
		
		model.addAttribute("user", user.getUsername());
		return "/main/mainWeb";
	}
}
