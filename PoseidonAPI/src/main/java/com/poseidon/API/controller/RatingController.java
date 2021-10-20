package com.poseidon.API.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poseidon.API.model.Rating;
import com.poseidon.API.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@GetMapping("/rating/{id}")
	public Rating getRating(@PathVariable("id") final Integer id) {
		Optional<Rating> rating = ratingService.getRating(id);
		if (rating.isPresent()) {
			return rating.get();
		} else {
			return null;
		}
	}

	@GetMapping("/ratings")
	public Iterable<Rating> getRatings() {
		return ratingService.getRatings();
	}

	@PostMapping("/rating")
	public Rating createRating(@RequestBody Rating rating) {
		return ratingService.saveRating(rating);
	}

	@DeleteMapping("/rating/{id}")
	public void deleteRating(@PathVariable("id") final Integer id) {
		ratingService.deleteRating(id);
	}

	@PutMapping("/rating/{id}")
	public Rating updateRating(@PathVariable("id") final Integer id, @RequestBody Rating rating) {
		Optional<Rating> e = ratingService.getRating(id);
		if (e.isPresent()) {
			Rating currentRating = e.get();

			String moodysRating = rating.getMoodysRating();
			if (moodysRating != null) {
				currentRating.setMoodysRating(moodysRating);
			}
			String sAndPRating = rating.getSAndPRating();
			if (sAndPRating != null) {
				currentRating.setSAndPRating(sAndPRating);
			}
			String fitchRating = rating.getFitchRating();
			if (fitchRating != null) {
				currentRating.setFitchRating(fitchRating);
			}
			Integer orderNumber = rating.getOrderNumber();
			if (orderNumber != null) {
				currentRating.setOrderNumber(orderNumber);
			}

			ratingService.saveRating(currentRating);
			return currentRating;
		} else {
			return null;
		}
	}

}