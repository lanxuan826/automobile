package com.automobile.model;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TSalePlan generated by hbm2java
 */
@Entity
@Table(name = "t_SalePlan", catalog = "automobile_db")
public class SalePlan implements java.io.Serializable {

	private SalePlanId id;
	private int regionId;
	private String autoTypeId;
	private Double planNum;
	private Date planDate;
	private Date startDate;
	private Date endDate;
	private String remark;

	public SalePlan() {
	}

	public SalePlan(SalePlanId id, int regionId, String autoTypeId,
			Date planDate) {
		this.id = id;
		this.regionId = regionId;
		this.autoTypeId = autoTypeId;
		this.planDate = planDate;
	}

	public SalePlan(SalePlanId id, int regionId, String autoTypeId,
			Double planNum, Date planDate, Date startDate, Date endDate,
			String remark) {
		this.id = id;
		this.regionId = regionId;
		this.autoTypeId = autoTypeId;
		this.planNum = planNum;
		this.planDate = planDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remark = remark;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "planId", column = @Column(name = "plan_id", nullable = false, length = 20)) })
	public SalePlanId getId() {
		return this.id;
	}

	public void setId(SalePlanId id) {
		this.id = id;
	}

	@Column(name = "region_id", nullable = false)
	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	@Column(name = "auto_type_id", nullable = false, length = 20)
	public String getAutoTypeId() {
		return this.autoTypeId;
	}

	public void setAutoTypeId(String autoTypeId) {
		this.autoTypeId = autoTypeId;
	}

	@Column(name = "plan_num", precision = 22, scale = 0)
	public Double getPlanNum() {
		return this.planNum;
	}

	public void setPlanNum(Double planNum) {
		this.planNum = planNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "plan_date", nullable = false, length = 10)
	public Date getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
