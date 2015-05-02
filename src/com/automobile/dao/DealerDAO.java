package com.automobile.dao;

import java.util.List;

import com.automobile.model.Customer;
import com.automobile.model.Dealer;

public interface DealerDAO  extends BaseDAO  {

	public void save(Dealer transientInstance);
	public void delete(Dealer transientInstance);
	public Dealer findById(Integer id);
	public List findByExample(Dealer transientInstance);
	public List findByWord(Object word);
	public List findByDealerValue(Object DealerValue);
	public List findAll();
	public List<Dealer> showDealerListAll();
	
	public List<Dealer> findDealerByProperty(String propertyName, Object value);

}
