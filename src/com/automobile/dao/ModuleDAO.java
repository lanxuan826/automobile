package com.automobile.dao;

import java.util.List;

import com.automobile.model.Module;

public interface ModuleDAO {

	public void save(Module transientInstance);
	public void delete(Module transientInstance);
	public Module findById(Integer id);
	public List findByExample(Module transientInstance);
	public List findByWord(Object word);
	public List findByModuleValue(Object ModuleValue);
	public List findAll();
}
