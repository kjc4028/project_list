package com.dev.jpa.usr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		return "home";
	}

	@RequestMapping("/show")
	public String show(Model model) throws NoSuchFieldException, SecurityException{
		List<UsrEntity> memberList =  usrService.findAll();
		System.out.println("show count-------------------" + memberList.size());
		for(UsrEntity mem : memberList){
			System.out.println("show-------------------");
		}
		model.addAttribute("mList",memberList);
		return "home";
	}

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinView(){
		return "";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String insert(){
		UsrEntity mem = new UsrEntity();
		usrService.save(mem);
		System.out.println("insert-------------------");
		return "home";
	}	
}
