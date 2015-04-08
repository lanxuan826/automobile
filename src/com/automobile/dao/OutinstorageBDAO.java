package com.automobile.dao;

import java.util.List;

import com.automobile.model.OutinstorageB;

public interface OutinstorageBDAO {

	public void save(OutinstorageB transientInstance);
	public void delete(OutinstorageB transientInstance);
	public OutinstorageB findById(Integer id);
	public List findByExample(OutinstorageB transientInstance);
	public List findByWord(Object word);
	public List findByOutinstorageBValue(Object OutinstorageBValue);
	public List findAll();
}
