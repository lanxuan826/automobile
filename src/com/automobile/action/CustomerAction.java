package com.automobile.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.PortableInterceptor.SUCCESSFUL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.automobile.model.Customer;
import com.automobile.service.ICustomerService;

public class CustomerAction {
	
		private ICustomerService custService;
		private JSONObject resultObject;
		private JSONArray resultArray;
		
		public String getCustomerInfoByAjax() {
			List<Customer>  custList = custService.showCustomersListAll();
			List listMap = new ArrayList();
			for (int i = 0; i < custList.size(); i++) {
				Map<String,String> m =new HashMap();
				m.put("id", custList.get(i).getCustId());
				m.put("text", custList.get(i).getCustName()+custList.get(i).getIdCard());
				listMap.add(m);
			}
			resultArray = JSONArray.fromObject(listMap);
			System.out.println(resultArray);
			return "success";
		}
		
		
		
		
		public JSONObject getResultObject() {
			return resultObject;
		}
		public void setResultObject(JSONObject resultObject) {
			this.resultObject = resultObject;
		}
		public ICustomerService getCustService() {
			return custService;
		}
		public void setCustService(ICustomerService custService) {
			this.custService = custService;
		}

		public JSONArray getResultArray() {
			return resultArray;
		}

		public void setResultArray(JSONArray resultArray) {
			this.resultArray = resultArray;
		}
		
}
