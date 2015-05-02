package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.AutoTypeDAO;
import com.automobile.dao.CustomerDAO;
import com.automobile.dao.AutoMobileDAO;
import com.automobile.model.AutoMobile;
import com.automobile.model.AutoType;
import com.automobile.service.IAutoMobileService;
import com.automobile.service.IAutoTypeService;

public class AutoTypeService implements IAutoTypeService {

	private AutoTypeDAO autoTypeDAO;

	public AutoTypeDAO getAutoTypeDAO() {
		return autoTypeDAO;
	}

	public void setAutoTypeDAO(AutoTypeDAO autoTypeDAO) {
		this.autoTypeDAO = autoTypeDAO;
	}

	@Override
	public List<AutoType> showAutoTypeListAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AutoType> showAutoTypeList() {
		return autoTypeDAO.findAll();
	}
	

}
