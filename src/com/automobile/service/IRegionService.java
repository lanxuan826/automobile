package com.automobile.service;

import java.util.List;

import com.automobile.model.Region;

public interface IRegionService {
	
	public List<Region> showRegionsListAll() ;
	
	public List<Region> getProviceList();
	
	public List<Region> getRegionInfoByProvice(Region region);
	
	public List<Region> getRegionById(String regionCode);
	
	public Region getRegionByFatherId(Integer fatherId);
}
