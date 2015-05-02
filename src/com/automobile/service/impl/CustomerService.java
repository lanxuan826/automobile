package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.CustomerDAO;
import com.automobile.model.Customer;
import com.automobile.service.ICustomerService;

public class CustomerService implements ICustomerService {

	private CustomerDAO customerDAO;
	
	public Customer findCustomerById(Integer Id) {
		return customerDAO.findById(Id);
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public List<Customer> showCustomersListAll() {
		return customerDAO.findAll();
	}

	@Override
	public List<Customer> findCustomerByCustId(String custId) {
		return customerDAO.findCustomerByCustId(custId);
	}

}
