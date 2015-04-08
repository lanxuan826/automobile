package com.automobile.dao;

import java.util.List;

import com.automobile.model.Log;

public interface LogDAO {

	public void save(Log transientInstance);
	public void delete(Log transientInstance);
	public Log findById(Integer id);
	public List findByExample(Log transientInstance);
	public List findByWord(Object word);
	public List findByLogValue(Object LogValue);
	public List findAll();
}
