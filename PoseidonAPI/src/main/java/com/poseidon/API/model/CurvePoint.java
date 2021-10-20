package com.poseidon.API.model;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "curve_points")
public class CurvePoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "curve_id")
	private Integer curveId;
	@Column(name = "as_of_date")
	private Timestamp asOfDate;
	private double term;
	private double value;
	@Column(name = "creation_date")
	private Timestamp creationDate;

	public CurvePoint() {
	}
	
	public CurvePoint(int id, Integer curveId, Timestamp asOfDate, double term, double value, Timestamp creationDate) {
		super();
		this.id = id;
		this.curveId = curveId;
		this.asOfDate = asOfDate;
		this.term = term;
		this.value = value;
		this.creationDate = creationDate;
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

	@Override
	public String toString() {
		return "CurvePoint [id=" + id + ", curveId=" + curveId + ", asOfDate=" + asOfDate + ", term=" + term
				+ ", value=" + value + ", creationDate=" + creationDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(asOfDate, creationDate, curveId, id, term, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurvePoint other = (CurvePoint) obj;
		return Objects.equals(asOfDate, other.asOfDate) && Objects.equals(creationDate, other.creationDate)
				&& curveId == other.curveId && id == other.id
				&& Double.doubleToLongBits(term) == Double.doubleToLongBits(other.term)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
	
	

}
