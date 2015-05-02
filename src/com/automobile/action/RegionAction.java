package com.automobile.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.automobile.model.Region;
import com.automobile.service.IRegionService;

public class RegionAction {
	
	private IRegionService RegionService;
	private JSONObject resultObject;
	private JSONArray resultArray;
	
	public String getRegionInfoByAjax() {
		List<Region>  RegionsList = RegionService.showRegionsListAll();
		List listMap = new ArrayList();
		for (int i = 0; i < RegionsList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", RegionsList.get(i).getRegionCode());
			m.put("text", RegionsList.get(i).getRegionName());
			listMap.add(m);
			}
		resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}

	public String getProviceInfo() {
		List<Region>  RegionsList = RegionService.getProviceList();
		List listMap = new ArrayList();
		for (int i = 0; i < RegionsList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", RegionsList.get(i).getRegionCode());
			m.put("text", RegionsList.get(i).getRegionName());
			listMap.add(m);
			}
		resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}
	
	public String getRegioninfoByProvice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fatherId = request.getParameter("proviceID");
		Region region = new Region();
		region.setFatherId(Integer.parseInt(fatherId));
		List<Region>  RegionsList = RegionService.getRegionInfoByProvice(region);
		List listMap = new ArrayList();
		for (int i = 0; i < RegionsList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", RegionsList.get(i).getRegionCode());
			m.put("text", RegionsList.get(i).getRegionName());
			listMap.add(m);
			}
		resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}
	
	public IRegionService getRegionService() {
		return RegionService;
	}

	public void setRegionService(IRegionService RegionService) {
		this.RegionService = RegionService;
	}

	public JSONObject getResultObject() {
		return resultObject;
	}

	public void setResultObject(JSONObject resultObject) {
		this.resultObject = resultObject;
	}

	public JSONArray getResultArray() {
		return resultArray;
	}

	public void setResultArray(JSONArray resultArray) {
		this.resultArray = resultArray;
	}
	
	
	

	
	
	

}
