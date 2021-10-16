package com.poseidon.API.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.API.model.Bid;
import com.poseidon.API.repo.BidRepository;

@Service
public class BidService {
	
	@Autowired
	private BidRepository bidRepository;
	
	public Optional<Bid> getBid(final Integer id) {
		return bidRepository.findById(id);
	}
	
	public Iterable<Bid> getBids() {
		return bidRepository.findAll();
	}
	
	public void deleteBid(final Integer id) {
		bidRepository.deleteById(id);
	}
	
	public Bid saveBid(Bid bid) {
		Bid savedBid = bidRepository.save(bid);
		return savedBid;
	}

}
