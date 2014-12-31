package org.milkandpaper.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



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
	public Users getUser(Users user){
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Users userrow=(Users)session.createQuery("from Users users where users.username like :name").setString("name",user.getUsername()).uniqueResult();
		session.close();
		return userrow;
	
	}
	
	
}
