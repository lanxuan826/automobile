package com.automobile.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.automobile.model.AutoMobile;
import com.automobile.model.AutoType;
import com.automobile.model.Dealer;
import com.automobile.service.IAutoMobileService;
import com.automobile.service.IDealerService;

public class AutoMobileAction {
	
	
	private IAutoMobileService autoMobileService;
	private JSONObject resultObject;
	private JSONArray resultArray;;
	
	public String getAutoInfoByType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String typeID = request.getParameter("typeID");
		AutoType autoType = new AutoType();
		autoType.setAutoTypeId(typeID);
		List<AutoMobile>  autoMobileList = autoMobileService.getAutoInfoByType(autoType);
		List listMap = new ArrayList();
		for (int i = 0; i < autoMobileList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", autoMobileList.get(i).getAutoId());
			m.put("text", autoMobileList.get(i).getVin());
			listMap.add(m);
		}
			resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}

	public IAutoMobileService getAutoMobileService() {
		return autoMobileService;
	}

	public void setAutoMobileService(IAutoMobileService autoMobileService) {
		this.autoMobileService = autoMobileService;
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
