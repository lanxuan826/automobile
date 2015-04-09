package com.automobile.dao;

import java.util.List;

import com.automobile.model.SaleVoucherH;

public interface SaleVoucherHDAO {

	public void save(SaleVoucherH transientInstance);
	public void delete(SaleVoucherH transientInstance);
	public SaleVoucherH findById(Integer id);
	public List findByExample(SaleVoucherH transientInstance);
	public List findByWord(Object word);
	public List findBySalevoucherHValue(Object SalevoucherHValue);
	public List findAll();
}
