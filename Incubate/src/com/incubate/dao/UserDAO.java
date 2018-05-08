package com.incubate.dao;

import java.util.List;

import com.incubate.models.User;

public interface UserDAO {
	
	public boolean login(String username, String password);
	
	public void addUsers(User p);
	public void updateUsers(User p);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);

}
