package com.automobile.dao;

import java.util.List;

import com.automobile.model.UtilityBill;

public interface UtilityBillDAO {

	public void save(UtilityBill transientInstance);
	public void delete(UtilityBill transientInstance);
	public UtilityBill findById(Integer id);
	public List findByExample(UtilityBill transientInstance);
	public List findByWord(Object word);
	public List findByUtilityBillValue(Object UtilityBillValue);
	public List findAll();
}
