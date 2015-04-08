package com.automobile.dao;

import java.util.List;

import com.automobile.model.Storge;

public interface StorgeDAO {

	public void save(Storge transientInstance);
	public void delete(Storge transientInstance);
	public Storge findById(Integer id);
	public List findByExample(Storge transientInstance);
	public List findByWord(Object word);
	public List findByStorgeValue(Object StorgeValue);
	public List findAll();
}
