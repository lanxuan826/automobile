package com.automobile.dao;

import java.util.List;

import com.automobile.model.Power;

public interface PowerDAO {

	public void save(Power transientInstance);
	public void delete(Power transientInstance);
	public Power findById(Integer id);
	public List findByExample(Power transientInstance);
	public List findByWord(Object word);
	public List findByPowerValue(Object PowerValue);
	public List findAll();
}
