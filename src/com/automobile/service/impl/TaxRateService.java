package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.CustomerDAO;
import com.automobile.dao.TaxRateDAO;
import com.automobile.model.TaxRate;
import com.automobile.service.ITaxRateService;

public class TaxRateService implements ITaxRateService {

	private TaxRateDAO taxRateDAO;
	

	public TaxRateDAO getTaxRateDAO() {
		return taxRateDAO;
	}

	public void setTaxRateDAO(TaxRateDAO taxRateDAO) {
		this.taxRateDAO = taxRateDAO;
	}

	@Override
	public List<TaxRate> showTaxRateListAll() {
		return taxRateDAO.findAll();
	}

	@Override
	public TaxRate getTaxRateById(Integer id) {
		return taxRateDAO.findById(id);
	}
	
	

}
