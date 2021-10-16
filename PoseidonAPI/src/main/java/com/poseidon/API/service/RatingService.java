package com.poseidon.API.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.API.model.Rating;
import com.poseidon.API.repo.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public Optional<Rating> getRating(final Integer id) {
		return ratingRepository.findById(id);
	}
	
	public Iterable<Rating> getRatings() {
		return ratingRepository.findAll();
	}
	
	public void deleteRating(final Integer id) {
		ratingRepository.deleteById(id);
	}
	
	public Rating saveRating(Rating rating) {
		Rating savedRating = ratingRepository.save(rating);
		return savedRating;
	}

}
