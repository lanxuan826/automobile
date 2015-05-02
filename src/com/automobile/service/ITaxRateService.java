package com.automobile.service;

import java.util.List;

import com.automobile.model.Dealer;
import com.automobile.model.TaxRate;

public interface ITaxRateService {
	
	public List<TaxRate> showTaxRateListAll() ;
	
	public TaxRate getTaxRateById(Integer id);
}
