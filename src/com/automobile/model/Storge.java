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
 * Storge generated by hbm2java
 */
@Entity
@Table(name = "t_storge", catalog = "automobile_db")
public class Storge implements java.io.Serializable {

	private Integer stoId;
	private String stoName;
	private Integer regoinId;
	private Date stoBirth;
	private Integer stoNum;
	private String stoStatus;
	private Integer userId;
	private String stoAddress;
	private String stoPhone;
	private String stoFax;
	private String remark;

	public Storge() {
	}

	public Storge(String stoName) {
		this.stoName = stoName;
	}

	public Storge(String stoName, Integer regoinId, Date stoBirth,
			Integer stoNum, String stoStatus, Integer userId,
			String stoAddress, String stoPhone, String stoFax, String remark) {
		this.stoName = stoName;
		this.regoinId = regoinId;
		this.stoBirth = stoBirth;
		this.stoNum = stoNum;
		this.stoStatus = stoStatus;
		this.userId = userId;
		this.stoAddress = stoAddress;
		this.stoPhone = stoPhone;
		this.stoFax = stoFax;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sto_id", unique = true, nullable = false)
	public Integer getStoId() {
		return this.stoId;
	}

	public void setStoId(Integer stoId) {
		this.stoId = stoId;
	}

	@Column(name = "sto_name", nullable = false, length = 20)
	public String getStoName() {
		return this.stoName;
	}

	public void setStoName(String stoName) {
		this.stoName = stoName;
	}

	@Column(name = "regoin_id")
	public Integer getRegoinId() {
		return this.regoinId;
	}

	public void setRegoinId(Integer regoinId) {
		this.regoinId = regoinId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "sto_birth", length = 10)
	public Date getStoBirth() {
		return this.stoBirth;
	}

	public void setStoBirth(Date stoBirth) {
		this.stoBirth = stoBirth;
	}

	@Column(name = "sto_num")
	public Integer getStoNum() {
		return this.stoNum;
	}

	public void setStoNum(Integer stoNum) {
		this.stoNum = stoNum;
	}

	@Column(name = "sto_status", length = 5)
	public String getStoStatus() {
		return this.stoStatus;
	}

	public void setStoStatus(String stoStatus) {
		this.stoStatus = stoStatus;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "sto_address", length = 50)
	public String getStoAddress() {
		return this.stoAddress;
	}

	public void setStoAddress(String stoAddress) {
		this.stoAddress = stoAddress;
	}

	@Column(name = "sto_phone", length = 15)
	public String getStoPhone() {
		return this.stoPhone;
	}

	public void setStoPhone(String stoPhone) {
		this.stoPhone = stoPhone;
	}

	@Column(name = "sto_fax", length = 15)
	public String getStoFax() {
		return this.stoFax;
	}

	public void setStoFax(String stoFax) {
		this.stoFax = stoFax;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
