package org.milkandpaper.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override @Transactional
	public Users getUser(String username){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Users user=(Users)session.createQuery("from Users user where user.username like :name" ).setString("name",username).uniqueResult(); 
		tx.commit();
		session.close();
		return user;
		
		
	}

}
