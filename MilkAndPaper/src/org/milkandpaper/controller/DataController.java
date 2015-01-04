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
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 


@Controller
public class DataController {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	DataService dataService;

//	public void setDataService(DataService dataService) {
//		this.dataService = dataService;
//	}

	@RequestMapping(value="login")
	public ModelAndView getLoginForm() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="registration")
	public ModelAndView registerUser(@ModelAttribute Users user) {
		dataService.insertUser(user);
		Users userrow=dataService.getUser(user);
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("praveen201501@gmail.com", "krishna2015");
			}
		  });
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
	
	@RequestMapping(value="admin/users")
	public ModelAndView getUsersList() {
		List<Users> userList=dataService.getUserList();
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("userList",userList);
		modelView.setViewName("admin/users");
		return modelView;
	}
	

	@RequestMapping(value="approve")
	public ModelAndView approveUser(@RequestParam int userid) {
		List<Users> userList=dataService.getUserList();
		int approveUser=dataService.approveUser(userid);
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("userList",userList);
		modelView.setViewName("admin/users");
		return modelView;
	}
	

}
