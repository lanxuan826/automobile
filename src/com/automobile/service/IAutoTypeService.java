package com.automobile.service;

import java.util.List;

import com.automobile.model.AutoMobile;
import com.automobile.model.AutoType;
import com.automobile.model.Dealer;

public interface IAutoTypeService {
	
	public List<AutoType> showAutoTypeListAll() ;
	
	public List<AutoType> showAutoTypeList();
}
