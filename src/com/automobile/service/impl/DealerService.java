package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.CustomerDAO;
import com.automobile.dao.DealerDAO;
import com.automobile.model.Dealer;
import com.automobile.service.IDealerService;

public class DealerService implements IDealerService {

	private DealerDAO dealerDAO;
	
	public List<Dealer> showDealersListAll() {
		return dealerDAO.showDealerListAll();
	}

	public DealerDAO getDealerDAO() {
		return dealerDAO;
	}

	public void setDealerDAO(DealerDAO dealerDAO) {
		this.dealerDAO = dealerDAO;
	}

	@Override
	public List<Dealer> findDealerByDearerId(String dealId) {
		
		return dealerDAO.findDealerByProperty("dealId", dealId);
	}
	
	

}
