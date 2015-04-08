package com.automobile.dao;

import java.util.List;

import com.automobile.model.SalevoucherH;

public interface SalevoucherHDAO {

	public void save(SalevoucherH transientInstance);
	public void delete(SalevoucherH transientInstance);
	public SalevoucherH findById(Integer id);
	public List findByExample(SalevoucherH transientInstance);
	public List findByWord(Object word);
	public List findBySalevoucherHValue(Object SalevoucherHValue);
	public List findAll();
}
