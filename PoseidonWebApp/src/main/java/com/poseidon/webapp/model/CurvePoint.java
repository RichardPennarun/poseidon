package com.poseidon.webapp.model;

import java.sql.Timestamp;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CurvePoint {

	private int id;
	@NotNull(message = "Must not be null")
    @Min(value = 1, message = "Must not be null")
	private Integer curveId;
	private Timestamp asOfDate;
	private double term;
	private double value;
	private Timestamp creationDate;

	public CurvePoint() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCurveId() {
		return curveId;
	}

	public void setCurveId(Integer curveId) {
		this.curveId = curveId;
	}

	public Timestamp getAsOfDate() {
		return asOfDate;
	}

	public void setAsOfDate(Timestamp asOfDate) {
		this.asOfDate = asOfDate;
	}

	public double getTerm() {
		return term;
	}

	public void setTerm(double term) {
		this.term = term;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}
