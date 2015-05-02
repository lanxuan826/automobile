package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.CustomerDAO;
import com.automobile.dao.AutoMobileDAO;
import com.automobile.model.AutoMobile;
import com.automobile.model.AutoType;
import com.automobile.service.IAutoMobileService;

public class AutoMobileService implements IAutoMobileService {

	private AutoMobileDAO autoMobileDAO;

	public AutoMobileDAO getAutoMobileDAO() {
		return autoMobileDAO;
	}

	public void setAutoMobileDAO(AutoMobileDAO autoMobileDAO) {
		this.autoMobileDAO = autoMobileDAO;
	}


	@Override
	public List<AutoMobile> getAutoInfoByType(AutoType autoType) {
		return autoMobileDAO.getAutoInfoByType(autoType);
	}

	@Override
	public List<AutoMobile> showAutoMobileListAll() {
		return autoMobileDAO.findAll();
	}
	

}
