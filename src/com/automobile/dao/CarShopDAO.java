package com.automobile.dao;

import java.util.List;

import com.automobile.model.CarShop;

public interface CarShopDAO {

	public void save(CarShop transientInstance);
	public void delete(CarShop transientInstance);
	public CarShop findById(Integer id);
	public List findByExample(CarShop transientInstance);
	public List findByWord(Object word);
	public List findByCarShopValue(Object CarShopValue);
	public List findAll();
}
