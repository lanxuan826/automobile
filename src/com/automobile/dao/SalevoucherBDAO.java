package com.automobile.dao;

import java.util.List;

import com.automobile.model.SalevoucherB;

public interface SalevoucherBDAO {

	public void save(SalevoucherB transientInstance);
	public void delete(SalevoucherB transientInstance);
	public SalevoucherB findById(Integer id);
	public List findByExample(SalevoucherB transientInstance);
	public List findByWord(Object word);
	public List findBySalevoucherBValue(Object SalevoucherBValue);
	public List findAll();
}
