package com.poseidon.webapp.model;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Rating {
	
	private int id;
	private String moodysRating;
	private String sAndPRating;
	private String fitchRating;
	@NotNull(message = "Must not be null")
    @Min(value = 1, message = "Must not be null")
	private Integer orderNumber;
	
	public Rating() {
	}

	public Rating(int id, String moodysRating, String sAndPRating, String fitchRating, Integer orderNumber) {
		super();
		this.id = id;
		this.moodysRating = moodysRating;
		this.sAndPRating = sAndPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoodysRating() {
		return moodysRating;
	}

	public void setMoodysRating(String moodysRating) {
		this.moodysRating = moodysRating;
	}

	public String getSAndPRating() {
		return sAndPRating;
	}

	public void setSAndPRating(String sAndPRating) {
		this.sAndPRating = sAndPRating;
	}

	public String getFitchRating() {
		return fitchRating;
	}

	public void setFitchRating(String fitchRating) {
		this.fitchRating = fitchRating;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", moodysRating=" + moodysRating + ", sAndPRating=" + sAndPRating + ", fitchRating="
				+ fitchRating + ", orderNumber=" + orderNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fitchRating, id, moodysRating, orderNumber, sAndPRating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		return Objects.equals(fitchRating, other.fitchRating) && id == other.id
				&& Objects.equals(moodysRating, other.moodysRating) && orderNumber == other.orderNumber
				&& Objects.equals(sAndPRating, other.sAndPRating);
	}

	
	

}
