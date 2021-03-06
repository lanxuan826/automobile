package com.automobile.model;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TAutoMobile generated by hbm2java
 */
@Entity
@Table(name = "t_AutoMobile", catalog = "AutoMobile_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "auto_id"),
		@UniqueConstraint(columnNames = "cert_num"),
		@UniqueConstraint(columnNames = "auto_fac_num"),
		@UniqueConstraint(columnNames = "engine_num"),
		@UniqueConstraint(columnNames = "vin") })

public class AutoMobile implements java.io.Serializable {
	private Integer id;
	private String autoId;
	private String autoFacNum;
	private String engineNum;
	private String engineName;
	private String certNum;
	private String vin;
	private String autoName;
	private String autoTypeId;
	private String autoStatus;
	private String remark;

	public AutoMobile() {
	}

	public AutoMobile(String autoId, String autoFacNum, String engineNum,
			String engineName, String certNum, String vin, String autoName,
			String autoStatus) {
		this.autoId = autoId;
		this.autoFacNum = autoFacNum;
		this.engineNum = engineNum;
		this.engineName = engineName;
		this.certNum = certNum;
		this.vin = vin;
		this.autoName = autoName;
		this.autoStatus = autoStatus;
	}

	public AutoMobile(String autoId, String autoFacNum, String engineNum,
			String engineName, String certNum, String vin, String autoName,
			String autoTypeId, String autoStatus, String remark) {
		this.autoId = autoId;
		this.autoFacNum = autoFacNum;
		this.engineNum = engineNum;
		this.engineName = engineName;
		this.certNum = certNum;
		this.vin = vin;
		this.autoName = autoName;
		this.autoTypeId = autoTypeId;
		this.autoStatus = autoStatus;
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

	@Column(name = "auto_id", unique = true, nullable = false, length = 20)
	public String getAutoId() {
		return this.autoId;
	}

	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}

	@Column(name = "auto_fac_num", unique = true, nullable = false, length = 20)
	public String getAutoFacNum() {
		return this.autoFacNum;
	}

	public void setAutoFacNum(String autoFacNum) {
		this.autoFacNum = autoFacNum;
	}

	@Column(name = "engine_num", unique = true, nullable = false, length = 20)
	public String getEngineNum() {
		return this.engineNum;
	}

	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}

	@Column(name = "engine_name", nullable = false, length = 20)
	public String getEngineName() {
		return this.engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	@Column(name = "cert_num", unique = true, nullable = false, length = 20)
	public String getCertNum() {
		return this.certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	@Column(name = "vin", unique = true, nullable = false, length = 20)
	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Column(name = "auto_name", nullable = false, length = 20)
	public String getAutoName() {
		return this.autoName;
	}

	public void setAutoName(String autoName) {
		this.autoName = autoName;
	}

	@Column(name = "auto_type_id")
	public String getAutoTypeId() {
		return this.autoTypeId;
	}

	public void setAutoTypeId(String autoTypeId) {
		this.autoTypeId = autoTypeId;
	}

	@Column(name = "auto_status", nullable = false, length = 10)
	public String getAutoStatus() {
		return this.autoStatus;
	}

	public void setAutoStatus(String autoStatus) {
		this.autoStatus = autoStatus;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
