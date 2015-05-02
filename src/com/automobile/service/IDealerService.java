package com.automobile.service;

import java.util.List;

import com.automobile.model.Customer;
import com.automobile.model.Dealer;

public interface IDealerService {
	
	public List<Dealer> showDealersListAll() ;
	
	public List<Dealer> findDealerByDearerId(String dealId) ;

}
