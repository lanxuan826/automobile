package com.automobile.dao;

import java.util.List;

import com.automobile.model.TaxRate;

public interface TaxRateDAO {

	public void save(TaxRate transientInstance);
	public void delete(TaxRate transientInstance);
	public TaxRate findById(Integer id);
	public List findByExample(TaxRate transientInstance);
	public List findByWord(Object word);
	public List findByTaxRateValue(Object TaxRateValue);
	public List findAll();
}
