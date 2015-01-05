package org.milkandpaper.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	public int approveUser(int id){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("Update Users set enabled=:Enable,isApproved=:Approve where id= :id").
						setParameter("id",id).setParameter("Enable", true).setParameter("Approve", true);
		
		int result = query.executeUpdate();
		session.close();
		return result;
	}
	
	@Override
	public List<Users> approvedUsers(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Users> usersList=session.createQuery("from Users where enabled=:Enable and isApproved=:Approve").
							  setParameter("Enable", true).setParameter("Approve", true).list();
		session.close();
		return usersList;
	}
	
	@Override
	public List<Users> toBeApprovedUsers(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Users> usersList=session.createQuery("from Users where isApproved=:Approve").
							setParameter("Approve", false).list();
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
	
}
