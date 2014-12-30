package org.milkandpaper.controller;


import org.milkandpaper.domain.Users;
import org.milkandpaper.services.MilkandpaperService;
import org.milkandpaper.services.MilkandpaperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MNPController{
	
	@Autowired
	MilkandpaperService milkandpaperService;
	
	
	
	@RequestMapping("login")
	public ModelAndView getLoginView() {
		
		ModelAndView modelView=new ModelAndView();
		modelView.setViewName("login");
		return modelView;
		
	}
	
	@RequestMapping("registration")
	public ModelAndView userReg(@ModelAttribute Users user) {
		
		ModelAndView modelView=new ModelAndView();
		milkandpaperService.insertUser(user);
		modelView.setViewName("login");
		return modelView;
		
	}
	
}