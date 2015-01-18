package org.milkandpaper.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.milkandpaper.domain.Subscription;
import org.milkandpaper.domain.UpdateUsers;
import org.milkandpaper.domain.UserRole;
import org.milkandpaper.domain.Users;

import com.sun.jmx.snmp.Timestamp;


public interface DataService {
	public int insertUser(Users user);
	public Users getUser(int userid);
	public Users getUserByName(String username);
	public int updateUserProfile(Users user);
	public List<Users> getUserList();
	public void approveUser(int id,HashSet<UserRole> userRoles);
	public List<Users> approvedUsers();
	public List<Users> toBeApprovedUsers();
	public void rejectUser(int userid);
	public int disableUser(int userid);
	public int insertSubscription(Subscription sub,String username);
	public List getMilkSubscription(String username);
	public List getPaperSubscription(String username);
	public int updatePassword(String userName,String newPassword,String oldPassword);
	public int updateUserProfileRequest(UpdateUsers user);
	public List getUpdateReqUserdetails(String userName);
	public int updateUser(String userName,String updateReqTime);
}
