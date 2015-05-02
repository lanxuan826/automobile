package com.automobile.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.automobile.service.ISaleAnalysisService;

import net.sf.json.JSONArray;
public class SaleAnalysisAction {

	
	private ISaleAnalysisService saleAnalysisService;
	
	public String  getCount() {
	HttpServletRequest request = ServletActionContext.getRequest();
	//车型数据
	JSONArray carTypeCountDate = saleAnalysisService.getCarTypeCount();
	request.setAttribute("carTypeCountDate", carTypeCountDate);
	return "success";
	}
	
}
