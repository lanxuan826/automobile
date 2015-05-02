package com.automobile.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.automobile.model.AutoType;
import com.automobile.model.Dealer;
import com.automobile.service.IAutoTypeService;
import com.automobile.service.IDealerService;

public class AutoTypeAction {
	
	
	private IAutoTypeService autoTypeService;
	private JSONObject resultObject;
	private JSONArray resultArray;;
	
	public String getAutoTypeInfo() {
		List<AutoType>  autoTypeList = autoTypeService.showAutoTypeList();
		List listMap = new ArrayList();
		for (int i = 0; i < autoTypeList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", autoTypeList.get(i).getAutoTypeId());
			m.put("text", autoTypeList.get(i).getAutoType()+autoTypeList.get(i).getAutoTypeName());
			listMap.add(m);
		}
			resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}

	public IAutoTypeService getAutoTypeService() {
		return autoTypeService;
	}

	public void setAutoTypeService(IAutoTypeService autoTypeService) {
		this.autoTypeService = autoTypeService;
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
