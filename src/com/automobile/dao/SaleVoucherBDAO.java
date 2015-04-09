package com.automobile.dao;

import java.util.List;

import com.automobile.model.SaleVoucherB;

public interface SaleVoucherBDAO {

	public void save(SaleVoucherB transientInstance);
	public void delete(SaleVoucherB transientInstance);
	public SaleVoucherB findById(Integer id);
	public List findByExample(SaleVoucherB transientInstance);
	public List findByWord(Object word);
	public List findBySaleVoucherBValue(Object SaleVoucherBValue);
	public List findAll();
}
