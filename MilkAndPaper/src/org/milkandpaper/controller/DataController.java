package org.milkandpaper.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import org.milkandpaper.domain.ChangeSub;
import org.milkandpaper.domain.Feedback;
import org.milkandpaper.domain.MilkSubscription;
import org.milkandpaper.domain.PaperSubscription;
import org.milkandpaper.domain.Subscription;
import org.milkandpaper.domain.UpdateUsers;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mail.MailSender;

import com.sun.jmx.snmp.Timestamp;

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
	
	private List<String> floorNos;
	
	
	@Autowired
	public void setFloorNos(@Value("#{'${floorNos}'.split(',')}") String[] floorNos) {
		this.floorNos = Arrays.asList(floorNos);
	}
	
	private List<String> flotNos;
		
	@Autowired
	public void setFlotNos(@Value("#{'${flotNos}'.split(',')}")  String[] flotNos) {
		this.flotNos = Arrays.asList(flotNos);
	}
	
	private List<String> blockNames;
	
	@Autowired
	public void setBlockNames(@Value("#{'${blockNames}'.split(',')}")  String[]  blockNames) {
		this.blockNames = Arrays.asList(blockNames);
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
	
	@RequestMapping(value="users/profile")
	public ModelAndView getProfileForm() {
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); //get logged in username
		Users user=dataService.getUserByName(username);
		modelView.addObject("user",user);
		modelView.addObject("profileActive","active");
		
		modelView.addObject("floorNos",floorNos);
		modelView.addObject("flotNos",flotNos);
		modelView.addObject("blockNames",blockNames);
		modelView.setViewName("users/profile");
		return modelView;
	}
	
	@RequestMapping(value="feedbackSubmit")
	public ModelAndView feedbackSubmit(@ModelAttribute Feedback feedback) {
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); //get logged in username
		Users user=dataService.getUserByName(username);
		feedback.setUser(user);
		dataService.insertFeedback(feedback);
		modelView.setViewName("users/feedback");
		return modelView;
	}
	
	@RequestMapping(value="admin/getFeedbacks")
	public ModelAndView getFeedbacks() {
		ModelAndView modelView=new ModelAndView();
		List feedbacks=dataService.getFeedbacks();
		modelView.addObject("feedbacks", feedbacks);
		modelView.setViewName("admin/usersFeedback");
		return modelView;
	}
	
	@RequestMapping(value="users/feedback")
	public ModelAndView getFeedbackForm() {
		ModelAndView modelView=new ModelAndView();
		modelView.addObject("feedback","active");
		modelView.setViewName("users/feedback");
		return modelView;
	}
	
	@RequestMapping(value="users/changeSub")
	public ModelAndView getChangeSub() {
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); //get logged in username
		Users user=dataService.getUserByName(username);
		modelView.addObject("user",user);
		modelView.addObject("changeSub","active");
		modelView.setViewName("users/subChangeReq");
		return modelView;
	}
	
	@RequestMapping(value="change",method=RequestMethod.POST)
	public ModelAndView insertChangeSub(@ModelAttribute ChangeSub changeSub) {
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); //get logged in username
		Users user=dataService.getUserByName(username);
		changeSub.setUser(user);
		dataService.insertChangeSub(changeSub);
		modelView.addObject("user",user);
//		modelView.addObject("changeSub",new ChangeSub() );
		modelView.addObject("changeSub","active");
		modelView.setViewName("users/subChangeReq");
		return modelView;
	}
	
	@RequestMapping(value="close")
	public ModelAndView closeFeedback(@RequestParam int id) {
		ModelAndView modelView=new ModelAndView();
		dataService.closeFeedback(id);
		List feedbacks=dataService.getFeedbacks();
		modelView.addObject("feedbacks", feedbacks);
		modelView.setViewName("admin/usersFeedback");
		return modelView;
	}
	
	@RequestMapping(value="admin/updateReqUserDetails")
	public ModelAndView getUpdateReqUserDetails() {
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); //get logged in username
		List users=dataService.getUpdateReqUserdetails(username);
		modelView.addObject("user", new Users());
		modelView.addObject("updateuser", new UpdateUsers());
		modelView.addObject("users",users);
		modelView.setViewName("admin/updateRequestUsers");
		return modelView;
	}
	
	
	
	@RequestMapping(value="changePassword",method=RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam String currentPassword,String newPassword) {
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName(); //get logged in username
		Integer userId=dataService.updatePassword(userName,currentPassword,newPassword);
		Users user=dataService.getUserByName(userName);
		if(userId!=0)
			modelView.addObject("message","password updated successfully");
		if(userId==0)
			modelView.addObject("message","Enter correct password");
		modelView.addObject("userName",userName);
		modelView.addObject("user",user);
		modelView.addObject("passwordActive","active");
		modelView.setViewName("users/profile");
		return modelView;
	}
	
	@RequestMapping(value="approveChangeReq",method=RequestMethod.POST)
	public ModelAndView approveChangeReq(@RequestParam String username,@RequestParam String updateReqTime){
		ModelAndView modelView=new ModelAndView();
		dataService.updateUser(username,updateReqTime);
		List users=dataService.getUpdateReqUserdetails(username);
		modelView.addObject("user", new Users());
		modelView.addObject("updateuser", new UpdateUsers());
		modelView.addObject("users",users);
		modelView.setViewName("admin/updateRequestUsers");
		return modelView;
		
		
	}
	
	@RequestMapping(value="updateUserProfile",method=RequestMethod.POST)
	public ModelAndView updateUserProfile(@ModelAttribute UpdateUsers user) {
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName(); //get logged in username
		user.setUsername(userName);
		Integer userId=dataService.updateUserProfileRequest(user);
		modelView.addObject("userName",userName);
		modelView.addObject("profileActive","active");
		modelView.addObject("floorNos",floorNos);
		modelView.addObject("flotNos",flotNos);
		modelView.addObject("blockNames",blockNames);
		if(userId!=null)
		modelView.addObject("message","profile update request send successfully");
		String changedUserName = auth.getName(); //get logged in username
		Users updatedUser=dataService.getUserByName(changedUserName);
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
		mail.setTo(updatedUser.getEmail());
		mail.setCc("praveen201501@gmail.com");
		mail.setSubject("Re: " + updatedUser.getFirstname() + ", your request for profile update is submitted");
		mail.setText(" your request for profile update is submitted we will get back to you soon");
		try {
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't send message");
		}
		modelView.addObject("user",updatedUser);
		modelView.setViewName("users/profile");
		return modelView;
	}
	
	
	@RequestMapping(value="registration",method=RequestMethod.POST)
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
	
	
	
	
	@RequestMapping(value="users/subscription")
	public ModelAndView subscription() {
		//List<Users> userList=dataService.toBeApprovedUsers();
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); //get logged in username
		List papersub=dataService.getPaperSubscription(username);
		List milksub=dataService.getMilkSubscription(username);
		modelView.addObject("usersType",1);
		modelView.addObject("paperList",paperList);
		modelView.addObject("milkList",milkList);
		modelView.addObject("milksub",milksub);
		modelView.addObject("papersub",papersub);
		modelView.addObject("username",username);
		Users user=dataService.getUserByName(username);
		modelView.addObject("user",user);
		modelView.addObject("sub","active");
		modelView.addObject("subscription",new Subscription());
		modelView.setViewName("users/subscription");
		return modelView;
	}
	
	@RequestMapping(value="users/afterLoginView")
	public ModelAndView afterLoginView() {
		//List<Users> userList=dataService.toBeApprovedUsers();
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName(); //get logged in username
		List papersub=dataService.getPaperSubscription(userName);
		List milksub=dataService.getMilkSubscription(userName);
		Users user=dataService.getUserByName(userName);
		String isFirsTimeLogin=user.getLoginFirstTime().toString();
		if(isFirsTimeLogin.equals("no"))
		{
			modelView.addObject("usersType",1);
			modelView.addObject("paperList",paperList);
			modelView.addObject("milkList",milkList);
			modelView.addObject("milksub",milksub);
			modelView.addObject("papersub",papersub);
			modelView.addObject("username",userName);
			modelView.addObject("user",user);
			modelView.addObject("sub","active");
			modelView.addObject("subscription",new Subscription());
			modelView.setViewName("users/subscription");
		}
		
		else if(isFirsTimeLogin.equals("yes")) {
			dataService.updateFirstTimeLogin(user);
			modelView.addObject("user",user);
			modelView.addObject("profileActive","active");
			modelView.addObject("floorNos",floorNos);
			modelView.addObject("flotNos",flotNos);
			modelView.addObject("blockNames",blockNames);
			modelView.setViewName("users/profile");
		}
		
	
		return modelView;
	}
	
	@RequestMapping(value="insertSubscription",method=RequestMethod.POST)
	public ModelAndView insertSubscription(@ModelAttribute Subscription sub,@RequestParam int SubscriptionType) {
		//List<Users> userList=dataService.toBeApprovedUsers();
		ModelAndView modelView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); //get logged in username
		dataService.insertSubscription(sub,username);
		List papersub=dataService.getPaperSubscription(username);
		List milksub=dataService.getMilkSubscription(username);
		modelView.addObject("paperList",paperList);
		modelView.addObject("milkList",milkList);
		modelView.addObject("milksub",milksub);
		modelView.addObject("papersub",papersub);
		modelView.addObject("SubscriptionType",1);
		modelView.addObject("milk",new MilkSubscription());
		modelView.addObject("paper",new PaperSubscription());
		modelView.addObject("paperList",paperList);
		modelView.addObject("milkList",milkList);
		modelView.addObject("subscription",new Subscription());
		modelView.addObject("sub","active");
		modelView.setViewName("users/subscription");
		return modelView;
	}
	
	
	
	
}
