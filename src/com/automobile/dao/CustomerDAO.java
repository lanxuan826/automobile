package com.automobile.dao;

import java.util.List;

import com.automobile.model.Customer;

public interface CustomerDAO {

	public void save(Customer transientInstance);
	public void delete(Customer transientInstance);
	public Customer findById(Integer id);
	public List findByExample(Customer transientInstance);
	public List findByWord(Object word);
	public List findByCustomerValue(Object CustomerValue);
	public List findAll();
}
