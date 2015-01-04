package org.milkandpaper.dao;

import java.util.List;
import org.milkandpaper.domain.Users;


public interface DataDao {
	public int insertUser(Users user);
	public Users getUser(Users user);
	public List<Users> getUserList();
	public int approveUser(int id);
}
