package com.poseidon.API.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.API.model.Rating;

@SpringBootTest
public class RatingServiceTest {

	@Autowired
	private RatingService ratingService;

	@Before
	private void setUp() {
		ratingService = new RatingService();
	}

	@Test
	public void ratingServiceTest() {
		Rating ratingToSave = new Rating();
		ratingToSave.setMoodysRating("super");
		ratingToSave.setSAndPRating("cool");
		ratingToSave.setFitchRating("pas mal");
		ratingToSave.setOrderNumber(100);

		Rating createdRating = ratingService.saveRating(ratingToSave);
		assertThat(createdRating).isEqualTo(ratingToSave);

		ratingService.getRatings();
		
		ratingService.getRating(createdRating.getId());
		
		ratingService.deleteRating(createdRating.getId());
		
	}
}
