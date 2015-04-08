package com.automobile.service;

import java.util.List;

import com.automobile.model.User;


public interface IUserService {
		
	public void save(User user);
	
	public void delete(User user);
	public User login(String name,String password);
	
	public boolean isExits(String name);
	
	public List<User> showUserListAll() ;
	
	public void update(User user);
	
	public User  findUserById(Integer Id);
}
