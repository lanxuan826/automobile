package com.automobile.dao;

import java.util.List;

import com.automobile.model.Stoinventory;

public interface StoinventoryDAO {

	public void save(Stoinventory transientInstance);
	public void delete(Stoinventory transientInstance);
	public Stoinventory findById(Integer id);
	public List findByExample(Stoinventory transientInstance);
	public List findByWord(Object word);
	public List findByStoinventoryValue(Object StoinventoryValue);
	public List findAll();
}
