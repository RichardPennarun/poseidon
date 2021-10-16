package com.poseidon.API.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidon.API.model.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {
	
}
