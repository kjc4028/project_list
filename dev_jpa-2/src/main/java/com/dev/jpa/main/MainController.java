package com.dev.jpa.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

	@RequestMapping(value={"", "/"})
	public String mainView(HttpServletRequest req, HttpServletResponse res){
		return "/main/mainWeb";
	}
}
