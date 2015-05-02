package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.SaleVoucherBDAO;
import com.automobile.dao.SaleVoucherHDAO;
import com.automobile.model.SaleVoucherH;
import com.automobile.service.ISaleManageService;

public class SaleManageService implements ISaleManageService {
	
	private SaleVoucherHDAO saleVoucherHDAO;
	private SaleVoucherBDAO saleVoucherBDAO;
	public SaleVoucherBDAO getSaleVoucherBDAO() {
		return saleVoucherBDAO;
	}

	public void setSaleVoucherBDAO(SaleVoucherBDAO saleVoucherBDAO) {
		this.saleVoucherBDAO = saleVoucherBDAO;
	}

	public SaleVoucherHDAO getSaleVoucherHDAO() {
		return saleVoucherHDAO;
	}

	public void setSaleVoucherHDAO(SaleVoucherHDAO saleVoucherHDAO) {
		this.saleVoucherHDAO = saleVoucherHDAO;
	}


	public List<SaleVoucherH> showSaleVoucherHList() {
		return saleVoucherHDAO.findAll();
	}

}
