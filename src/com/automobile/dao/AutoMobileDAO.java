package com.automobile.dao;
import java.util.List;

import com.automobile.model.AutoMobile;
import com.automobile.model.AutoType;

public interface AutoMobileDAO {
	
	public void save(AutoMobile transientInstance);
	public void delete(AutoMobile transientInstance);
	public AutoMobile findById(Integer id);
	public List findByExample(AutoMobile transientInstance);
	public List findByWord(Object word);
	public List findByAutoMobileValue(Object AutoMobileValue);
	public List findAll();
	
	public List<AutoMobile> getAutoInfoByType(AutoType autoType);
}
