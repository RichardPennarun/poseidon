package com.poseidon.API.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidon.API.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
}
