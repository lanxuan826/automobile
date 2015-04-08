package com.automobile.dao;

import java.util.List;

import com.automobile.model.AutoType;

public interface AutoTypeDAO {
	
	public void save(AutoType transientInstance);
	public void delete(AutoType transientInstance);
	public AutoType findById(Integer id);
	public List findByExample(AutoType transientInstance);
	public List findByWord(Object word);
	public List findByAutoTypeValue(Object AutoTypeValue);
	public List findAll();
}
