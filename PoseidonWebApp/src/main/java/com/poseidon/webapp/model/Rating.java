package com.poseidon.webapp.model;

import java.util.Objects;


public class Rating {
	
	private int id;
	private String moodysRating;
	private String sandPRating;
	private String fitchRating;
	private int orderNumber;
	
	public Rating() {
	}

	public Rating(int id, String moodysRating, String sandPRating, String fitchRating, int orderNumber) {
		super();
		this.id = id;
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
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

	public String getSandPRating() {
		return sandPRating;
	}

	public void setSandPRating(String sandPRating) {
		this.sandPRating = sandPRating;
	}

	public String getFitchRating() {
		return fitchRating;
	}

	public void setFitchRating(String fitchRating) {
		this.fitchRating = fitchRating;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", moodysRating=" + moodysRating + ", sandPRating=" + sandPRating + ", fitchRating="
				+ fitchRating + ", orderNumber=" + orderNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fitchRating, id, moodysRating, orderNumber, sandPRating);
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
				&& Objects.equals(sandPRating, other.sandPRating);
	}

	
	

}
