package com.automobile.dao;

import java.util.List;

import com.automobile.model.User;

public interface UserDAO extends BaseDAO{
	
		public void save(User user);
		
		public List findUserByName(String username);
		
		public User  findUserById(Integer Id);
		
		public List findUserByProperty(String propertyName, Object value);
		
		public boolean isExits(String username);

		public List<User> showUserListAll();
		
		public void delele(User user);
		
		public void update(User user);
}
