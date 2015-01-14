package org.milkandpaper.dao;

import java.util.HashSet;
import java.util.List;




import org.milkandpaper.domain.Subscription;
import org.milkandpaper.domain.UserRole;
import org.milkandpaper.domain.Users;

public interface DataDao {
	public int insertUser(Users user);
	public Users getUser(int userid);
	public List<Users> getUserList();
	public void approveUser(int id,HashSet<UserRole> userRoles);
	public List<Users> approvedUsers();
	public List<Users> toBeApprovedUsers();
	public void rejectUser(int userid);
	public int disableUser(int userid);
	public int insertSubscription(Subscription sub,String username);
	public List getMilkSubscription(String username);
	public List getPaperSubscription(String username);
	
}
