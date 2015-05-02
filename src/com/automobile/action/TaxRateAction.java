package com.automobile.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.automobile.model.TaxRate;
import com.automobile.service.ITaxRateService;

public class TaxRateAction {
	
	
	private ITaxRateService taxRateService;
	private JSONObject resultObject;
	private JSONArray resultArray;;
	
	public String getTaxRateInfo() {
		List<TaxRate>  taxRatesList = taxRateService.showTaxRateListAll();
		List listMap = new ArrayList();
		for (int i = 0; i < taxRatesList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("id", taxRatesList.get(i).getTaxId().toString());
			m.put("text", taxRatesList.get(i).getTaxName());
			listMap.add(m);
		}
			resultArray = JSONArray.fromObject(listMap);
		System.out.println(resultArray);
		return "success";
	}

	public ITaxRateService getTaxRateService() {
		return taxRateService;
	}

	public void setTaxRateService(ITaxRateService taxRateService) {
		this.taxRateService = taxRateService;
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
