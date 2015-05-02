package com.automobile.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.automobile.model.Dealer;
import com.automobile.model.Storge;
import com.automobile.service.IDealerService;
import com.automobile.service.IStorgeService;

public class StorgeAction {
	

	private IStorgeService storgeService;
	private JSONObject resultObject;
	private JSONArray resultArray;;
	
	public String getStoInfoByAjax() {
		List<Storge>  storgeList = storgeService.showStorgesListAll();
		List listMap = new ArrayList();
		for (int i = 0; i < storgeList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", storgeList.get(i).getStoId().toString());
			m.put("text", storgeList.get(i).getStoName());
			listMap.add(m);
		}
		resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}

	public IStorgeService getStorgeService() {
		return storgeService;
	}

	public void setStorgeService(IStorgeService storgeService) {
		this.storgeService = storgeService;
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
