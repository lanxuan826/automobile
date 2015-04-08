package com.automobile.dao;

import java.util.List;

import com.automobile.model.Saleplan;

public interface SaleplanDAO {

	public void save(Saleplan transientInstance);
	public void delete(Saleplan transientInstance);
	public Saleplan findById(Integer id);
	public List findByExample(Saleplan transientInstance);
	public List findByWord(Object word);
	public List findBySaleplanValue(Object SaleplanValue);
	public List findAll();
}
