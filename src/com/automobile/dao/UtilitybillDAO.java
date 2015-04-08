package com.automobile.dao;

import java.util.List;

import com.automobile.model.Utilitybill;

public interface UtilitybillDAO {

	public void save(Utilitybill transientInstance);
	public void delete(Utilitybill transientInstance);
	public Utilitybill findById(Integer id);
	public List findByExample(Utilitybill transientInstance);
	public List findByWord(Object word);
	public List findByUtilitybillValue(Object UtilitybillValue);
	public List findAll();
}
