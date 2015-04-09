package com.automobile.dao;

import java.util.List;

import com.automobile.model.OutInStorageH;

public interface OutInstorageHDAO {

	public void save(OutInStorageH transientInstance);
	public void delete(OutInStorageH transientInstance);
	public OutInStorageH findById(Integer id);
	public List findByExample(OutInStorageH transientInstance);
	public List findByWord(Object word);
	public List findByOutinstorageHValue(Object OutinstorageHValue);
	public List findAll();
}
