package com.automobile.dao;

import java.util.List;

import com.automobile.model.SalePlan;

public interface SalePlanDAO {

	public void save(SalePlan transientInstance);
	public void delete(SalePlan transientInstance);
	public SalePlan findById(Integer id);
	public List findByExample(SalePlan transientInstance);
	public List findByWord(Object word);
	public List findBySaleplanValue(Object SaleplanValue);
	public List findAll();
}
