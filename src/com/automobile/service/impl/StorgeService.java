package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.CustomerDAO;
import com.automobile.dao.DealerDAO;
import com.automobile.dao.StorgeDAO;
import com.automobile.model.Dealer;
import com.automobile.model.Storge;
import com.automobile.service.IDealerService;
import com.automobile.service.IStorgeService;

public class StorgeService implements IStorgeService {

	private StorgeDAO storgeDAO;

	@Override
	public List<Storge> showStorgesListAll() {
		return storgeDAO.findAll();
	}

	public StorgeDAO getStorgeDAO() {
		return storgeDAO;
	}

	public void setStorgeDAO(StorgeDAO storgeDAO) {
		this.storgeDAO = storgeDAO;
	}

	@Override
	public Storge getStorgeById(int stoId) {
		return storgeDAO.findById(stoId);
	}
	
	
	
	

}
