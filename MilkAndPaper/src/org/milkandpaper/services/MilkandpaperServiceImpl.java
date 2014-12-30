package org.milkandpaper.services;

import org.milkandpaper.dao.MilkandpaperDao;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MilkandpaperServiceImpl implements MilkandpaperService {

	@Autowired
	MilkandpaperDao milkandpapaerDao;
	
	@Override
	public int insertUser(Users user) {
		// TODO Auto-generated method stub
		return milkandpapaerDao.insertUser(user);
	}

}
