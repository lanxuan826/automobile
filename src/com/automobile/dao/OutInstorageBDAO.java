package com.automobile.dao;

import java.util.List;

import com.automobile.model.OutInStorageB;


public interface OutInstorageBDAO {

	public void save(OutInStorageB transientInstance);
	public void delete(OutInStorageB transientInstance);
	public OutInStorageB findById(Integer id);
	public List findByExample(OutInStorageB transientInstance);
	public List findByWord(Object word);
	public List findByOutInstorageBValue(Object OutInstorageBValue);
	public List findAll();
}
