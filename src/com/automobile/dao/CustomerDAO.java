package com.automobile.dao;

import java.util.List;

import com.automobile.model.Customer;

public interface CustomerDAO extends BaseDAO {

	public void save(Customer transientInstance);
	public void delete(Customer transientInstance);
	public Customer findById(Integer id);
	public List findByExample(Customer transientInstance);
	public List findByWord(Object word);
	public List findByCustomerValue(Object CustomerValue);
	public List findAll();
	
	public List<Customer> findCustomerByProperty(String propertyName, Object value);
	
	public List<Customer> findCustomerByCustId(String id);
	
}
