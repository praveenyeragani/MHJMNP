package org.milkandpaper.dao;

import org.milkandpaper.domain.Users;


public interface LoginDao {
	
	Users getUser(String username);
}
