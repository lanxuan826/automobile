package com.automobile.service;

import java.util.List;

import com.automobile.model.Customer;

public interface ICustomerService {

	
	public Customer  findCustomerById(Integer Id);
	
	public List<Customer> showCustomersListAll() ;
	
	public List<Customer>  findCustomerByCustId(String custId) ;
}
