package org.milkandpaper.dao;

import java.util.List;
import org.milkandpaper.domain.Users;


public interface DataDao {
	public int insertUser(Users user);
	public Users getUser(int userid);
	public List<Users> getUserList();
	public int approveUser(int id);
	public List<Users> approvedUsers();
	public List<Users> toBeApprovedUsers();
	public void rejectUser(int userid);
	public int disableUser(int userid);
	
}
