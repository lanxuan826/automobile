package com.automobile.model;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TaxRate generated by hbm2java
 */
@Entity
@Table(name = "t_TaxRate", catalog = "automobile_db")
public class TaxRate implements java.io.Serializable {

	private Integer taxId;
	private String taxName;
	private double TaxRate;
	private String taxIntro;
	private String remark;

	public TaxRate() {
	}

	public TaxRate(String taxName, double TaxRate) {
		this.taxName = taxName;
		this.TaxRate = TaxRate;
	}

	public TaxRate(String taxName, double TaxRate, String taxIntro,
			String remark) {
		this.taxName = taxName;
		this.TaxRate = TaxRate;
		this.taxIntro = taxIntro;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tax_id", unique = true, nullable = false)
	public Integer getTaxId() {
		return this.taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	@Column(name = "tax_name", nullable = false, length = 20)
	public String getTaxName() {
		return this.taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	@Column(name = "tax_rate", nullable = false, precision = 22, scale = 0)
	public double getTaxRate() {
		return this.TaxRate;
	}

	public void setTaxRate(double TaxRate) {
		this.TaxRate = TaxRate;
	}

	@Column(name = "tax_intro", length = 50)
	public String getTaxIntro() {
		return this.taxIntro;
	}

	public void setTaxIntro(String taxIntro) {
		this.taxIntro = taxIntro;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}