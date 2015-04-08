package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.UserDAO;
import com.automobile.model.User;
import com.automobile.service.IUserService;

public class UserService implements IUserService {

	private UserDAO userDAO;

	public User login(String name, String password) {
		
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userDAO.findUserByName(name);
		if (userList.size() > 0) {
			User user = userList.get(0);
			if(user!=null && password.equals(user.getPassword())) {
				return user;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	public boolean isExits(String id) {
		return userDAO.isExits(id);
	}
	
	public void save(User user) {
		userDAO.save(user);
	}
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User>showUserListAll() {
		
		return userDAO.showUserListAll();
	}

	@Override
	public void delete(User user) {
		userDAO.delele(user);
		
	}

	@Override
	public User findUserById(Integer Id) {
		return userDAO.findUserById(Id);
	}

	@Override
	public void update(User user) {
			userDAO.update(user);
	}
	


	
}
