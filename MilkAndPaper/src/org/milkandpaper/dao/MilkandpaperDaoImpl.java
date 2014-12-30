package org.milkandpaper.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;

public class MilkandpaperDaoImpl implements MilkandpaperDao {
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int insertUser(Users user) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		Serializable id=session.getIdentifier(user);
		session.close();
		return (Integer)id;
	}

}
