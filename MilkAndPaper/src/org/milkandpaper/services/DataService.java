package org.milkandpaper.services;

import java.util.List;

import org.milkandpaper.domain.Users;


public interface DataService {
	public int insertUser(Users user);
	public Users getUser(Users user);
	public List<Users> getUserList();


	

}
