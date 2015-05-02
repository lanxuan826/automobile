package com.automobile.service;

import java.util.List;

import com.automobile.model.AutoMobile;
import com.automobile.model.AutoType;
import com.automobile.model.Dealer;

public interface IAutoMobileService {
	
	public List<AutoMobile> showAutoMobileListAll() ;
	
	public List<AutoMobile>  getAutoInfoByType(AutoType autoType);
}
