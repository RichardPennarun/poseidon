package com.poseidon.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.webapp.model.Rating;
import com.poseidon.webapp.proxy.RatingProxy;

@Service
public class RatingService {

    @Autowired
    private RatingProxy ratingProxy;

	
    public Iterable<Rating> getRatings() {
        return ratingProxy.getRatings();
    }
	
	public Rating getRating(final int id) {
		return ratingProxy.getRating(id);
	}
	
	public void deleteRating(final int id) {
		ratingProxy.deleteRating(id);
	}
	
	public Rating saveRating(Rating rating) {
		Rating savedRating;

		if(rating.getId() == 0) {
			savedRating = ratingProxy.createRating(rating);
		} else {
			savedRating = ratingProxy.updateRating(rating);
		}
		
		return savedRating;
	}

}
