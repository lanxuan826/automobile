package com.automobile.service.impl;

import java.util.List;

import com.automobile.dao.CustomerDAO;
import com.automobile.dao.RegionDAO;
import com.automobile.model.Region;
import com.automobile.service.IRegionService;
import com.automobile.service.IRegionService;

public class RegionService implements IRegionService {

	private RegionDAO regionDAO;
	
	public List<Region> showRegionsListAll() {
		return regionDAO.showRegionListAll();
	}

	public RegionDAO getRegionDAO() {
		return regionDAO;
	}

	public void setRegionDAO(RegionDAO regionDAO) {
		this.regionDAO = regionDAO;
	}

	@Override
	public List<Region> getProviceList() {
		return regionDAO.showProviceList();
	}

	public List<Region> getRegionInfoByProvice(Region region) {
		return regionDAO.getRegionInfoByProvice(region);
	}

	public List<Region> getRegionById(String regionCode) {
		return  regionDAO.findByProperty("regionCode", regionCode);
	}

	public Region getRegionByFatherId(Integer fatherId) {
		return (Region) regionDAO.findByProperty("fatherId", fatherId).get(0);
	}
	
	

}
