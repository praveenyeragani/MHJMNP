package org.milkandpaper.controller;

import java.util.List;

import org.milkandpaper.domain.Users;
import org.milkandpaper.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mail.MailSender;


@Controller
public class DataController {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	DataService dataService;

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	@RequestMapping(value="login")
	public ModelAndView getLoginForm() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="registration")
	public ModelAndView registerUser(@ModelAttribute Users user) {
		dataService.insertUser(user);
		Users userrow=dataService.getUser(user);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("praveen201501@gmail.com");
		mail.setTo(userrow.getEmail());
		mail.setSubject("Re: " + userrow.getFirstname() + ", your message");
		mail.setText("hi");
		
		try {
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't send message");
		}

		return new ModelAndView("login");
	}
	
	

}
