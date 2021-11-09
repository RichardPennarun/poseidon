package com.poseidon.API.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "moodys_rating")
	private String moodysRating;
	@Column(name = "s_and_p_rating")
	private String sAndPRating;
	@Column(name = "fitch_rating")
	private String fitchRating;
	@Column(name = "order_number")
	private Integer orderNumber;
	
	public Rating() {
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

}
