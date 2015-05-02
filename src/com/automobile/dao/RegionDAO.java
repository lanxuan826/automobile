package com.automobile.dao;

import java.util.List;

import com.automobile.model.Region;

public interface RegionDAO  extends BaseDAO  {

	public void save(Region transientInstance);
	public void delete(Region transientInstance);
	public Region findById(Integer id);
	public List findByExample(Region transientInstance);
	public List findByWord(Object word);
	public List findByRegionValue(Object RegionValue);
	public List findAll();
	public List<Region> showRegionListAll();
	public List findByProperty(String propertyName, Object value);
	
	public List<Region>  showProviceList();
	public List<Region>  getRegionInfoByProvice(Region instance);
}
