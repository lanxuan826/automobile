package com.automobile.dao;

import java.util.List;

import com.automobile.model.Role;

public interface RoleDAO {

	public void save(Role transientInstance);
	public void delete(Role transientInstance);
	public Role findById(Integer id);
	public List findByExample(Role transientInstance);
	public List findByWord(Object word);
	public List findByRoleValue(Object RoleValue);
	public List findAll();
}
