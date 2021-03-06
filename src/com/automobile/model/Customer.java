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
 * TCustomer generated by hbm2java
 */
@Entity
@Table(name = "t_customer", catalog = "automobile_db")
public class Customer implements java.io.Serializable {

	private Integer id;
	private String custId;
	private String custName;
	private Date custBirth;
	private String idCard;
	private int regionId;
	private String custJob;
	private String custCompany;
	private String custType;
	private Integer custFamilyNum;
	private String custYearMoney;
	private String custTel;
	private String custAddress;
	private String custQq;
	private String custEmail;
	private String remark;

	public Customer() {
	}

	public Customer(String custId, String custName, int regionId) {
		this.custId = custId;
		this.custName = custName;
		this.regionId = regionId;
	}

	public Customer(String custId, String custName, Date custBirth,
			String idCard, int regionId, String custJob, String custCompany,
			String custType, Integer custFamilyNum, String custYearMoney,
			String custTel, String custAddress, String custQq,
			String custEmail, String remark) {
		this.custId = custId;
		this.custName = custName;
		this.custBirth = custBirth;
		this.idCard = idCard;
		this.regionId = regionId;
		this.custJob = custJob;
		this.custCompany = custCompany;
		this.custType = custType;
		this.custFamilyNum = custFamilyNum;
		this.custYearMoney = custYearMoney;
		this.custTel = custTel;
		this.custAddress = custAddress;
		this.custQq = custQq;
		this.custEmail = custEmail;
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

	@Column(name = "cust_id", nullable = false, length = 10)
	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	@Column(name = "cust_name", nullable = false, length = 20)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cust_birth", length = 10)
	public Date getCustBirth() {
		return this.custBirth;
	}

	public void setCustBirth(Date custBirth) {
		this.custBirth = custBirth;
	}

	@Column(name = "id_card", length = 20)
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "region_id", nullable = false)
	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	@Column(name = "cust_job", length = 20)
	public String getCustJob() {
		return this.custJob;
	}

	public void setCustJob(String custJob) {
		this.custJob = custJob;
	}

	@Column(name = "cust_company", length = 50)
	public String getCustCompany() {
		return this.custCompany;
	}

	public void setCustCompany(String custCompany) {
		this.custCompany = custCompany;
	}

	@Column(name = "cust_type", length = 6)
	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	@Column(name = "cust_family_num")
	public Integer getCustFamilyNum() {
		return this.custFamilyNum;
	}

	public void setCustFamilyNum(Integer custFamilyNum) {
		this.custFamilyNum = custFamilyNum;
	}

	@Column(name = "cust_year_money", length = 10)
	public String getCustYearMoney() {
		return this.custYearMoney;
	}

	public void setCustYearMoney(String custYearMoney) {
		this.custYearMoney = custYearMoney;
	}

	@Column(name = "cust_tel", length = 15)
	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	@Column(name = "cust_address", length = 50)
	public String getCustAddress() {
		return this.custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Column(name = "cust_qq", length = 15)
	public String getCustQq() {
		return this.custQq;
	}

	public void setCustQq(String custQq) {
		this.custQq = custQq;
	}

	@Column(name = "cust_email", length = 20)
	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
