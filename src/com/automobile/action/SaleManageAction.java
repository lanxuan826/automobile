package com.automobile.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.swing.ListModel;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.automobile.model.Customer;
import com.automobile.model.Region;
import com.automobile.model.SaleVoucherH;
import com.automobile.model.TaxRate;
import com.automobile.model.User;
import com.automobile.service.ICustomerService;
import com.automobile.service.IDealerService;
import com.automobile.service.IRegionService;
import com.automobile.service.ISaleManageService;
import com.automobile.service.IStorgeService;
import com.automobile.service.ITaxRateService;
import com.automobile.service.IUserService;
import com.automobile.util.SystemUtil;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.StringUtil;

public class SaleManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ISaleManageService saleManageService;
	private ICustomerService custService;
	private IDealerService dealerService;
	private IStorgeService storgeService;
	private IUserService userService;
	private ITaxRateService taxRateService;
	private IRegionService regionService;
	private JSONObject resultObject;
	
	public String showSaleData() {
		return "ok";
	}
	
	public String addCarSaleForm() {
		return "ok";
	}
	
	public String redirctCarSaleManage(){
		return "ok";
	}
	/**
	 * 查询销售单头信息
	 * @return
	 */
	public String showSaleVoucherHData() {
		List<SaleVoucherH> svhList = saleManageService.showSaleVoucherHList();
		Map map = new HashMap();
		List listMap = new ArrayList();
		for (int i = 0; i < svhList.size(); i++) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("saleId", svhList.get(i).getSaleId());
			int customerType = svhList.get(i).getCustomerType();
			String type = "个人";
			System.out.println("========="+svhList.get(i).getCustomerId());
			Customer customer = custService.findCustomerByCustId(svhList.get(i).getCustomerId()).get(0);
			String customerName = customer.getCustName();
			if(customerType != 0){
				type = "经销商";
				customerName = (dealerService.findDealerByDearerId(svhList.get(i).getCustomerId())).get(0).getDealName();
			}
			
//			 storgeService.getStorgeById(svhList.get(i).getStoId()).getStoName()
			m.put("customerType", type);
			m.put("customerName", customerName);
			m.put("saleDate",svhList.get(i).getSaleDate().toString());
			m.put("storgeName","长沙市第一仓库");
			User user = userService.findUserById(svhList.get(i).getUserId());
			m.put("userName",user.getUsername()+user.getNickname());
			List<Region> regionList = regionService.getRegionById(svhList.get(i).getRegionId());
			Region region = null;
			if(regionList.size() > 0){
				region = regionList.get(0);
			}
			String regionName = region.getRegionName().toString();
//			if (region != null) {
//				for (int j = 3; j < region.getRegionCode().length(); j+=2) {
//						String code = region.getRegionCode().substring(0, region.getRegionCode().length()-2);
//						System.out.println("===="+code);
//						System.out.println(regionName);
//						region = regionService.getRegionById(code).get(0);
//						regionName.append(region.getRegionName());
//						System.out.println(regionName);
//				}
//			}
			m.put("regionName",regionName.toString());
			m.put("isPay", "是");
			if(!svhList.get(i).getIsPay()){
				m.put("isPay", "否");
			}
			TaxRate taxRate = taxRateService.getTaxRateById(svhList.get(i).getTaxId());
			m.put("taxName", taxRate.getTaxName());
			m.put("totalMoney", svhList.get(i).getTotalMoney().toString());
			m.put("taxAfter", svhList.get(i).getAfterTax().toString());
			if(svhList.get(i).getRemark() == null) {
				m.put("remark", "");
			}
			listMap.add(m);
		}
		map.put("total", svhList.size());
		map.put("rows", listMap);
		resultObject = JSONObject.fromObject(map);
		System.out.println(resultObject);
		return "success";
	}

	

	public ISaleManageService getSaleManageService() {
		return saleManageService;
	}

	public void setSaleManageService(ISaleManageService saleManageService) {
		this.saleManageService = saleManageService;
	}
//
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

	public IRegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}

	public IDealerService getDealerService() {
		return dealerService;
	}

	public void setDealerService(IDealerService dealerService) {
		this.dealerService = dealerService;
	}

	public IStorgeService getStorgeService() {
		return storgeService;
	}

	public void setStorgeService(IStorgeService storgeService) {
		this.storgeService = storgeService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ITaxRateService getTaxRateService() {
		return taxRateService;
	}

	public void setTaxRateService(ITaxRateService taxRateService) {
		this.taxRateService = taxRateService;
	}

	
	
}
