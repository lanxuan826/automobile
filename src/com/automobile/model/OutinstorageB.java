package com.automobile.model;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TOutinstorageB generated by hbm2java
 */
@Entity
@Table(name = "t_outinstorage_b", catalog = "automobile_db")
public class OutinstorageB implements java.io.Serializable {

	private Integer pkOutinB;
	private OutinstorageH OutinstorageH;
	private String autoTypeId;
	private Integer number;
	private Date billDate;

	public OutinstorageB() {
	}

	public OutinstorageB(OutinstorageH OutinstorageH, String autoTypeId) {
		this.OutinstorageH = OutinstorageH;
		this.autoTypeId = autoTypeId;
	}

	public OutinstorageB(OutinstorageH OutinstorageH, String autoTypeId,
			Integer number, Date billDate) {
		this.OutinstorageH = OutinstorageH;
		this.autoTypeId = autoTypeId;
		this.number = number;
		this.billDate = billDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pk_outin_b", unique = true, nullable = false)
	public Integer getPkOutinB() {
		return this.pkOutinB;
	}

	public void setPkOutinB(Integer pkOutinB) {
		this.pkOutinB = pkOutinB;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pk_outin_h", nullable = false)
	public OutinstorageH getTOutinstorageH() {
		return this.OutinstorageH;
	}

	public void setTOutinstorageH(OutinstorageH OutinstorageH) {
		this.OutinstorageH = OutinstorageH;
	}

	@Column(name = "auto_type_id", nullable = false, length = 20)
	public String getAutoTypeId() {
		return this.autoTypeId;
	}

	public void setAutoTypeId(String autoTypeId) {
		this.autoTypeId = autoTypeId;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "bill_date", length = 10)
	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

}
