package com.dev.jpa.usr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.jpa.usr.entity.UsrEntity;
import com.dev.jpa.usr.service.UsrService;


@Controller
@RequestMapping("/usr")
public class UsrController {
	
	private Logger logger = LoggerFactory.getLogger(UsrController.class);

	@Autowired
	UsrService usrService;
	
	@RequestMapping("")
	public String home(){
		logger.info("home page connect...한글테스트");
		return "redirect:/";
	}

	@RequestMapping("/show")
	public String show(Model model) throws NoSuchFieldException, SecurityException{
		List<UsrEntity> memberList =  usrService.findAll();
		System.out.println("show count-------------------" + memberList.size());
		for(UsrEntity mem : memberList){
			System.out.println("show-------------------");
		}
		model.addAttribute("mList",memberList);
		return "redirect:/";
	}

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinView(HttpServletRequest req, HttpServletResponse res, UsrEntity usrEntity, Model model){
		return "usr/usrC";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String insert(HttpServletRequest req, HttpServletResponse res, UsrEntity usrEntity, Model model){
		usrService.save(usrEntity);
		System.out.println("insert-------------------");
		System.out.println(usrEntity);
		return "redirect:/";
	}	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView(HttpServletRequest req, HttpServletResponse res, UsrEntity usrEntity, Model model){
		return "usr/login";
	}	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse res, UsrEntity usrEntity, Model model){
		logger.info("login----------------------------------------");
		logger.info("---------------------------------------------");
		return "redirect:/";
	}	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loout(HttpServletRequest request, HttpServletResponse response) throws Exception {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/";
	}


}
