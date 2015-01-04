package org.milkandpaper.services;

import java.util.List;

import org.milkandpaper.dao.DataDao;
import org.milkandpaper.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
	public Users getUser(int userid){
		return dataDao.getUser(userid);
	}
	
	@Override
	public List<Users> getUserList(){
		return dataDao.getUserList();
	}
	
	@Override
	public int approveUser(int id){
		return dataDao.approveUser(id);
	}
	
	@Override
	public List<Users> approvedUsers(){
		return dataDao.approvedUsers();
	}
	
	@Override
	public List<Users> toBeApprovedUsers(){
		return dataDao.toBeApprovedUsers();
	}

}
