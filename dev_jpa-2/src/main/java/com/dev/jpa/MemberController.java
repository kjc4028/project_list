package com.dev.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	MemberRepository repo;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}

	@RequestMapping("/show")
	public String show(Model model) throws NoSuchFieldException, SecurityException{
		List<Member> memberList =  repo.findAll();
		System.out.println("show count-------------------" + memberList.size());
		for(Member mem : memberList){
			System.out.println("show-------------------");
		}
		model.addAttribute("mList",memberList);
		return "home";
	}
	
	@RequestMapping("/insert")
	public String insert(){
		
		Member mem = new Member("test");
		
		repo.save(mem);
		System.out.println("insert-------------------");
		return "home";
	}	
}
