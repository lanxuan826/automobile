package com.automobile.model;

import java.io.Serializable;
import java.util.List;

public class SaleVoucherEntire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SaleVoucherH  head = null;
	
	private List<SaleVoucherB> bodies = null;

	public SaleVoucherH getHead() {
		return head;
	}

	public void setHead(SaleVoucherH head) {
		this.head = head;
	}

	public List<SaleVoucherB> getBodies() {
		return bodies;
	}

	public void setBodies(List<SaleVoucherB> bodies) {
		this.bodies = bodies;
	}
	
	
	
}
