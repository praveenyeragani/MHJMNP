package org.milkandpaper.controller;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import org.milkandpaper.domain.MilkSubscription;
import org.milkandpaper.domain.PaperSubscription;
import org.milkandpaper.domain.Subscription;
import org.milkandpaper.domain.Users;
import org.milkandpaper.domain.UserRole;
import org.milkandpaper.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	private List<String> paperList;
	
	@Autowired
	@ModelAttribute("paperList")
	public void setPaperList(@Value("#{'${paperlist}'.split(',')}") String[] paperList) {
		this.paperList = Arrays.asList(paperList);
	}

	
	private List<String> milkList;
	

	@Autowired
	@ModelAttribute("milkList")
	public void setMilkList(@Value("#{'${milklist}'.split(',')}") String[] milkList) {
		this.milkList = Arrays.asList(milkList);
	}
	
	@ModelAttribute("sub")
	public void setAtt(){
		MilkSubscription milksub;
		PaperSubscription papersub;
	}

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
		Users userrow=dataService.getUser(user.getId());
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
		List<Users> userList=dataService.toBeApprovedUsers();
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("usersType",1);
		modelView.addObject("userList",userList);
		modelView.setViewName("admin/users");
		return modelView;
	}
	

	@RequestMapping(value="approve")
	public ModelAndView approveUser(@RequestParam int userid) {
		Users user=dataService.getUser(userid);
		UserRole userRole=new UserRole();
//		userRole.setUser(user);
		userRole.setRole("ROLE_USER");
		HashSet<UserRole> userRoles=new HashSet<UserRole>();
		userRoles.add(userRole);
		//user.getUserRole().add(userRole);
		List<Users> userList=dataService.toBeApprovedUsers();
		dataService.approveUser(userid,userRoles);
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("userList",userList);
		modelView.setViewName("admin/users");
		return modelView;
	}
	
	@RequestMapping(value="usersType", method = RequestMethod.POST)
	public ModelAndView usersType(@RequestParam int userType){
		List<Users> userList=null;
		ModelAndView modelView=new ModelAndView();
		if(userType==1){
			userList=dataService.toBeApprovedUsers();
			modelView.addObject("usersType",1);
		}
		
		if(userType==2){
			userList=dataService.approvedUsers();
			modelView.addObject("usersType",2);
		}
		
		modelView.addObject("userList",userList);
		modelView.setViewName("admin/users");
		return modelView;
	}
	
	@RequestMapping(value="edit")
	public ModelAndView edit(@RequestParam int userid){
		Users user=dataService.getUser(userid);
		Set<UserRole> userRoles=user.getUserRole();
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("user",user);
		modelView.addObject("userRoles",userRoles);
		modelView.addObject("userRole",new UserRole());
		
		
		modelView.setViewName("admin/editUser");
		return modelView;
	}
	
	@RequestMapping(value="newUser")
	public ModelAndView newUser(){
		
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("user",new Users());
		modelView.setViewName("admin/editUser");
		return modelView;
	}
	
	@RequestMapping(value="reject",method=RequestMethod.POST)
	public ModelAndView reject(@RequestParam int userid){
		dataService.rejectUser(userid);
		ModelAndView modelView=new ModelAndView();
		List<Users> userList=dataService.toBeApprovedUsers();
		modelView.addObject("userList",userList);
		modelView.addObject("user",new Users());
		modelView.setViewName("admin/users");
		return modelView;
	}
	
	@RequestMapping(value="disable",method=RequestMethod.POST)
	public ModelAndView disable(@RequestParam int userid){
		int disableUser=dataService.disableUser(userid);
		ModelAndView modelView=new ModelAndView();
		List<Users> userList=dataService.toBeApprovedUsers();
		modelView.addObject("userList",userList);
		modelView.addObject("user",new Users());
		modelView.setViewName("admin/users");
		modelView.addObject("usersType",1);
		return modelView;
	}
	
	
	
	
	@RequestMapping(value="users/subscription", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView subscription() {
		//List<Users> userList=dataService.toBeApprovedUsers();
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("usersType",1);
//		modelView.addObject("milk",new MilkSubscription());
//		modelView.addObject("paper",new PaperSubscription());
		modelView.addObject("paperList",paperList);
		modelView.addObject("milkList",milkList);
		modelView.addObject("subscription",new Subscription());
		modelView.setViewName("users/subscription");
		return modelView;
	}
	
	@RequestMapping(value="insertSubscription",method=RequestMethod.POST)
	public ModelAndView insertSubscription(@ModelAttribute Subscription sub,@RequestParam int SubscriptionType) {
		//List<Users> userList=dataService.toBeApprovedUsers();
		ModelAndView modelView=new ModelAndView();
		dataService.insertSubscription(sub);
		modelView.addObject("SubscriptionType",1);
		modelView.addObject("milk",new MilkSubscription());
		modelView.addObject("paper",new PaperSubscription());
		modelView.addObject("paperList",paperList);
		modelView.addObject("milkList",milkList);
		
		modelView.addObject("subscription",new Subscription());
		
		modelView.setViewName("users/subscription");
		return modelView;
	}
	
}
