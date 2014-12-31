package org.milkandpaper.services;

import org.milkandpaper.dao.DataDao;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class DataServiceImpl implements DataService {
	
	@Autowired
	DataDao dataDao;

//	public void setDataDao(DataDao dataDao) {
//		this.dataDao = dataDao;
//	}

	@Override
	public int insertUser(Users user) {
		return dataDao.insertUser(user);
	}
	
	@Override
	public Users getUser(Users user){
		return dataDao.getUser(user);
	}
	


}
