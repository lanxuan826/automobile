package com.automobile.dao;

import java.util.List;

import com.automobile.model.StoInventory;

public interface StoInventoryDAO {

	public void save(StoInventory transientInstance);
	public void delete(StoInventory transientInstance);
	public StoInventory findById(Integer id);
	public List findByExample(StoInventory transientInstance);
	public List findByWord(Object word);
	public List findByStoInventoryValue(Object StoInventoryValue);
	public List findAll();
}
