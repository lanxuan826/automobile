package com.automobile.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.automobile.model.Dealer;
import com.automobile.service.IDealerService;

public class DealerAction {
	
	
	private IDealerService dealerService;
	private JSONObject resultObject;
	private JSONArray resultArray;;
	
	public String getDealerInfoByAjax() {
		List<Dealer>  dealersList = dealerService.showDealersListAll();
		List listMap = new ArrayList();
		for (int i = 0; i < dealersList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", dealersList.get(i).getDealId());
			m.put("text", dealersList.get(i).getDealName());
			listMap.add(m);
		}
			resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}

	public IDealerService getDealerService() {
		return dealerService;
	}

	public void setDealerService(IDealerService dealerService) {
		this.dealerService = dealerService;
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
