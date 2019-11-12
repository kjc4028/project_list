package com.dev.jpa.usr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.jpa.usr.entity.UsrEntity;
import com.dev.jpa.usr.repository.UsrRepository;

@Controller
public class UsrController {

	@Autowired
	UsrRepository repo;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}

	@RequestMapping("/show")
	public String show(Model model) throws NoSuchFieldException, SecurityException{
		List<UsrEntity> memberList =  repo.findAll();
		System.out.println("show count-------------------" + memberList.size());
		for(UsrEntity mem : memberList){
			System.out.println("show-------------------");
		}
		model.addAttribute("mList",memberList);
		return "home";
	}
	
	@RequestMapping("/insert")
	public String insert(){
		
		UsrEntity mem = new UsrEntity();
		
		repo.save(mem);
		System.out.println("insert-------------------");
		return "home";
	}	
}
