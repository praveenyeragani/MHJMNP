package org.milkandpaper.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.milkandpaper.domain.MilkSubscription;
import org.milkandpaper.domain.PaperSubscription;
import org.milkandpaper.domain.Subscription;
import org.milkandpaper.domain.UserRole;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
	
	public void rejectUser(int userid){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Users user =(Users)session.get(Users.class, userid); 
		session.delete(user);
		tx.commit();
		session.close();
	}
	
	public int disableUser(int userid){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("Update Users set isApproved=:Approve where id= :id").
						setParameter("id",userid).setParameter("Approve", false);
		int result = query.executeUpdate();
		session.close();
		return result;
	}
	
	public int insertSubscription(Subscription sub){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		MilkSubscription milksub=new MilkSubscription();
		PaperSubscription paperSub=new PaperSubscription();
		Serializable id ;
		
		if(sub.getMilksub().getQuantity().equals("")){
			paperSub=sub.getPapersub();
			session.save(paperSub);
			tx.commit();
			id=session.getIdentifier(paperSub);
		}
		
		else{

			milksub=sub.getMilksub();
			session.save(milksub);
			tx.commit();
			id =session.getIdentifier(milksub);
		}
		
		session.close();
		return (Integer) id;
	}
	
}
