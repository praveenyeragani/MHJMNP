package org.milkandpaper.dao;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.milkandpaper.domain.ChangeSub;
import org.milkandpaper.domain.Feedback;
import org.milkandpaper.domain.MilkSubscription;
import org.milkandpaper.domain.PaperSubscription;
import org.milkandpaper.domain.Subscription;
import org.milkandpaper.domain.UpdateUsers;
import org.milkandpaper.domain.UserRole;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jmx.snmp.Timestamp;




@Component
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insertUser(Users user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return (Integer) id;
	}
	
	@Override
	@Transactional
	public Users getUser(int userid){
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Users userrow=(Users)session.createQuery("from Users users where users.id like :id").setParameter("id",userid).uniqueResult();
		session.close();
		return userrow;
	
	}
	
	public Users getUserByName(String username){
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Users userrow=(Users)session.createQuery("from Users users where users.username like :username").setParameter("username",username).uniqueResult();
		session.close();
		return userrow;
		
	}
	
	public int updatePassword(String userName,String oldPassword,String newPassword){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("Update Users set password=:newPassword where username= :userName and password =:oldPassword").
						setParameter("userName",userName).setParameter("newPassword", newPassword).setParameter("oldPassword", oldPassword);
		int id=query.executeUpdate();
		tx.commit();
		session.close();
		return id;
	}
	
	@Override
	@Transactional
	public int updateUserProfileRequest(UpdateUsers user){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return (Integer)id;
		
	} 
	
	@Override
	public List getUpdateReqUserdetails(String userName){
		
		Session session = sessionFactory.openSession();
		List usersList=session.createQuery("from UpdateUsers updateuser,Users user  where updateuser.username=user.username").list();
		session.close();
		return usersList;
		
	}
	
	
	@Override
	public List getFeedbacks(){
		
		Session session = sessionFactory.openSession();
		List usersList=session.createQuery("from Users user,Feedback feedback  where feedback.user.id=user.id").list();
		session.close();
		return usersList;
		
	}

	public int updateUserProfile(Users user){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("Update Users set firstname=:firstname,lastname=:lastname,email=:email,phoneno=:phoneno,"
							+ "blockname=:blockname,floorno=:floorno,flotno=:flotno where username= :userName").
						setParameter("firstname",user.getFirstname()).setParameter("lastname",user.getLastname()).
						setParameter("blockname", user.getBlockName()).setParameter("floorno", user.getFloorno()).
						setParameter("flotno", user.getFlotno()).setParameter("flotno", user.getFlotno()).
						setParameter("userName",user.getUsername()).setParameter("email",user.getEmail()).
						setParameter("phoneno",user.getPhoneno());
	
		int id=query.executeUpdate();
		tx.commit();
		session.close();
		return (Integer)id;
		
	}
	
	@Override
	public List<Users> getUserList(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Users> usersList=session.createQuery("from Users").list();
		session.close();
		return usersList;
	}
	
	@Override
	public void approveUser(int id,HashSet<UserRole> userRoles){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserRole userRole=new UserRole();
		userRole.setRole("ROLE_USER");
		Users user=(Users)session.get(Users.class,new Integer(id));
		userRole.setUser(user);
//		userRole.setUser(user);
		
		user.setEnabled(true);
		user.setIsApproved(true);
		
		HashSet<UserRole> userRoles1=new HashSet<UserRole>();
		userRoles.add(userRole);
		(user.getUserRole()).add(userRole);
//		@SuppressWarnings("unchecked")
//		Users user=(Users)session.createQuery("Update Users set enabled=:Enable,isApproved=:Approve where id= :id").
//						setParameter("id",id).setParameter("Enable", true).setParameter("Approve", true).uniqueResult();
//		
//		session.update(user);
		tx.commit();
		
		session.close();
		
	}
	
	@Override
	public List<Users> approvedUsers(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Users> usersList=session.createQuery("from Users where isApproved=:Approve").
							setParameter("Approve",new Boolean(true)).list();
		session.close();
		return usersList;
	}
	
	@Override
	public List<Users> toBeApprovedUsers(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Users> usersList=session.createQuery("from Users where isApproved=:Approve").
							setParameter("Approve",new Boolean(false)).list();
		session.close();
		return usersList;
	}
	
	@Override
	public void rejectUser(int userid){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Users user =(Users)session.get(Users.class, userid); 
		session.delete(user);
		tx.commit();
		session.close();
	}
	
	@Override
	public int updateUser(String userName,String updateReqTime){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
		Date date = formatter.parse(updateReqTime);
		
		UpdateUsers user=(UpdateUsers)session.createQuery("from UpdateUsers where username=:userName and updateReqTime=:updateReqTime").
						setParameter("userName", userName).setParameter("updateReqTime", date).uniqueResult();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("Update Users set firstname=:firstname,lastname=:lastname,email=:email,phoneno=:phoneno,"
							+ "blockname=:blockname,floorno=:floorno,flotno=:flotno where username= :userName").
						setParameter("firstname",user.getFirstname()).setParameter("lastname",user.getLastname()).
						setParameter("blockname", user.getBlockName()).setParameter("floorno", user.getFloorno()).
						setParameter("flotno", user.getFlotno()).setParameter("flotno", user.getFlotno()).
						setParameter("userName",userName).setParameter("email",user.getEmail()).
						setParameter("phoneno",user.getPhoneno());
		
		int id=query.executeUpdate();
		tx.commit();
		session.close();
		return (Integer)id;
		}
		catch (ParseException e) {
				e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int disableUser(int userid){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("Update Users set isApproved=:Approve where id= :id").
						setParameter("id",userid).setParameter("Approve", false);
		int result = query.executeUpdate();
		session.close();
		return result;
	}
	
	@Override
	public int insertSubscription(Subscription sub,String username){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		MilkSubscription milksub=new MilkSubscription();
		PaperSubscription paperSub=new PaperSubscription();
		Serializable id ;
		@SuppressWarnings("unchecked")
		Users user=(Users)session.createQuery("from Users users where users.username like :username").setParameter("username",username).uniqueResult();
		
		
		if(sub.getMilksub().getQuantity().equals("")){
			paperSub=sub.getPapersub();
			paperSub.setUser(user);
			session.save(paperSub);
			tx.commit();
			id=session.getIdentifier(paperSub);
		}
		
		else{

			milksub=sub.getMilksub();
			milksub.setUser(user);
			session.save(milksub);
			tx.commit();
			id =session.getIdentifier(milksub);
		}
		
		session.close();
		return (Integer) id;
	}
	
	@Override
	public List getMilkSubscription(String username){
		
		Session session = sessionFactory.openSession();
		
//		List usersList=session.createQuery(" from MilkSubscription milksub,PaperSubscription papersub where milksub.user.username like :username ").
//							  setParameter("username",username).list();
		
//		List usersList=session.createSQLQuery("select MilkSubscription.milkname,MilkSubscription.quantity ,PaperSubscription.papername from MilkSubscription "
//				+ "join PaperSubscription on MilkSubscription.id in"
//				+ " (select id from users where users.username like :username) ").
//				setParameter("username",username).list();
		
		@SuppressWarnings("unchecked")
		List milkSubList=session.createQuery(" from MilkSubscription milksub where milksub.user.username like :username ").
						setParameter("username",username).list();
		
		session.close();
		return milkSubList;
	}
	
	
	@Override
	public List getPaperSubscription(String username){
		
		Session session = sessionFactory.openSession();
	
		@SuppressWarnings("unchecked")
		List milkSubList=session.createQuery(" from PaperSubscription papersub where papersub.user.username like :username ").
						setParameter("username",username).list();
		
		session.close();
		return milkSubList;
	}
	
	@Override
	public int insertFeedback(Feedback feedback){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(feedback);
		tx.commit();
		Serializable id = session.getIdentifier(feedback);
		session.close();
		return (Integer) id;
		
	}
	
	@Override
	public int closeFeedback(int id){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("Update Feedback  set status=:status where user.id=:id").
						setParameter("id", id).setParameter("status", "close");
		int updateId =query.executeUpdate();
		tx.commit();
		session.close();
		return updateId;
		
	}
	
	@Override
	public int insertChangeSub(ChangeSub changeSub){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(changeSub);
		tx.commit();
		Serializable id = session.getIdentifier(changeSub);
		session.close();
		return (Integer) id;
		
	} 
	
	@Override
	public int updateFirstTimeLogin(Users user){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("Update Users set login_First_Time=:isFirstTimeLogin where id=:id").
						setParameter("id", user.getId()).setParameter("isFirstTimeLogin","no");
		int updateId =query.executeUpdate();
		tx.commit();
		session.close();
		return updateId;
		
	}
	
}
