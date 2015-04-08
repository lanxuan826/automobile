package com.automobile.dao;

import java.util.List;

import com.automobile.model.OutinstorageH;

public interface OutinstorageHDAO {

	public void save(OutinstorageH transientInstance);
	public void delete(OutinstorageH transientInstance);
	public OutinstorageH findById(Integer id);
	public List findByExample(OutinstorageH transientInstance);
	public List findByWord(Object word);
	public List findByOutinstorageHValue(Object OutinstorageHValue);
	public List findAll();
}
