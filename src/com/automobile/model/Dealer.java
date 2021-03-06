package com.automobile.model;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TDealer generated by hbm2java
 */
@Entity
@Table(name = "t_dealer", catalog = "automobile_db")
public class Dealer implements java.io.Serializable {

	private Integer id;
	private String dealId;
	private String dealName;
	private Date dealBirth;
	private int regionId;
	private String dealAssrt;
	private String dealYearMoney;
	private String dealType;
	private String dealTelName;
	private String dealAddress;
	private String dealPhone;
	private String dealFax;
	private String custQq;
	private String remark;

	public Dealer() {
	}

	public Dealer(String dealId, String dealName, int regionId) {
		this.dealId = dealId;
		this.dealName = dealName;
		this.regionId = regionId;
	}

	public Dealer(String dealId, String dealName, Date dealBirth,
			int regionId, String dealAssrt, String dealYearMoney,
			String dealType, String dealTelName, String dealAddress,
			String dealPhone, String dealFax, String custQq, String remark) {
		this.dealId = dealId;
		this.dealName = dealName;
		this.dealBirth = dealBirth;
		this.regionId = regionId;
		this.dealAssrt = dealAssrt;
		this.dealYearMoney = dealYearMoney;
		this.dealType = dealType;
		this.dealTelName = dealTelName;
		this.dealAddress = dealAddress;
		this.dealPhone = dealPhone;
		this.dealFax = dealFax;
		this.custQq = custQq;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "deal_id", nullable = false, length = 10)
	public String getDealId() {
		return this.dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	@Column(name = "deal_name", nullable = false, length = 20)
	public String getDealName() {
		return this.dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "deal_birth", length = 10)
	public Date getDealBirth() {
		return this.dealBirth;
	}

	public void setDealBirth(Date dealBirth) {
		this.dealBirth = dealBirth;
	}

	@Column(name = "region_id", nullable = false)
	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	@Column(name = "deal_assrt", length = 20)
	public String getDealAssrt() {
		return this.dealAssrt;
	}

	public void setDealAssrt(String dealAssrt) {
		this.dealAssrt = dealAssrt;
	}

	@Column(name = "deal_year_money", length = 20)
	public String getDealYearMoney() {
		return this.dealYearMoney;
	}

	public void setDealYearMoney(String dealYearMoney) {
		this.dealYearMoney = dealYearMoney;
	}

	@Column(name = "deal_type", length = 6)
	public String getDealType() {
		return this.dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	@Column(name = "deal_tel_name", length = 20)
	public String getDealTelName() {
		return this.dealTelName;
	}

	public void setDealTelName(String dealTelName) {
		this.dealTelName = dealTelName;
	}

	@Column(name = "deal_address", length = 50)
	public String getDealAddress() {
		return this.dealAddress;
	}

	public void setDealAddress(String dealAddress) {
		this.dealAddress = dealAddress;
	}

	@Column(name = "deal_phone", length = 15)
	public String getDealPhone() {
		return this.dealPhone;
	}

	public void setDealPhone(String dealPhone) {
		this.dealPhone = dealPhone;
	}

	@Column(name = "deal_fax", length = 20)
	public String getDealFax() {
		return this.dealFax;
	}

	public void setDealFax(String dealFax) {
		this.dealFax = dealFax;
	}

	@Column(name = "cust_qq", length = 15)
	public String getCustQq() {
		return this.custQq;
	}

	public void setCustQq(String custQq) {
		this.custQq = custQq;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
