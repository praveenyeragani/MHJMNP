package org.milkandpaper.services;

import java.util.HashSet;
import java.util.List;

import org.milkandpaper.dao.DataDao;
import org.milkandpaper.domain.Subscription;
import org.milkandpaper.domain.UserRole;
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
	public void approveUser(int id,HashSet<UserRole> userRoles){
		dataDao.approveUser(id,userRoles);
	}
	
	@Override
	public List<Users> approvedUsers(){
		return dataDao.approvedUsers();
	}
	
	@Override
	public List<Users> toBeApprovedUsers(){
		return dataDao.toBeApprovedUsers();
	}
	
	@Override
	public void rejectUser(int userid){
		dataDao.rejectUser(userid);
	}
	
	@Override
	public int disableUser(int userid){
		return dataDao.disableUser(userid);
	}
	
	@Override
	public int insertSubscription(Subscription sub,String username){
		return dataDao.insertSubscription(sub,username);
	}
	
	@Override
	public List getMilkSubscription(String username){
		
		return dataDao.getMilkSubscription(username);
	}
	
	@Override
	public List getPaperSubscription(String username){
		
		return dataDao.getPaperSubscription(username);
	}

}
