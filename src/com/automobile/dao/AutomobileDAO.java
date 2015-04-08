package com.automobile.dao;

import java.util.List;

import com.automobile.model.Automobile;


public interface AutomobileDAO {
	
	public void save(Automobile transientInstance);
	public void delete(Automobile transientInstance);
	public Automobile findById(Integer id);
	public List findByExample(Automobile transientInstance);
	public List findByWord(Object word);
	public List findByAutomobileValue(Object AutomobileValue);
	public List findAll();
}
