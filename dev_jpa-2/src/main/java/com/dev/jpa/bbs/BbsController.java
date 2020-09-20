package com.dev.jpa.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.jpa.category.CategoryService;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	private BbsService bbsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectList(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		model.addAttribute("pageList", bbsService.findAll());
		
		return "bbs/bbsList";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String bbsInsertView(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		
		//사용중인 카테고리 리스트 호출
		model.addAttribute("categoryList", categoryService.findByUseYn("Y"));
		
		return "bbs/bbsCU";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bbsInsert(Model model, HttpServletRequest request, HttpServletResponse response, BbsEntity bbsEntity) {
		String replageCts = bbsEntity.getContents().replace("\n", "<br>");
		bbsEntity.setContents(replageCts);
		bbsService.save(bbsEntity);
		return "redirect:/bbs/list";
	}
	
	
}
