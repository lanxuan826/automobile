package com.automobile.dao;

import java.util.List;

import com.automobile.model.Taxrate;

public interface TaxrateDAO {

	public void save(Taxrate transientInstance);
	public void delete(Taxrate transientInstance);
	public Taxrate findById(Integer id);
	public List findByExample(Taxrate transientInstance);
	public List findByWord(Object word);
	public List findByTaxrateValue(Object TaxrateValue);
	public List findAll();
}
