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

import com.poseidon.API.model.Bid;
import com.poseidon.API.service.BidService;

@RestController
public class BidController {
	
	@Autowired
	private BidService bidService;
	
	
	@GetMapping("/bid/{id}")
	public Bid getBid(@PathVariable("id") final Integer id) {
		Optional<Bid> bid = bidService.getBid(id);
		if(bid.isPresent()) {
			return bid.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/bids")
	public Iterable<Bid> getBids() {
		return bidService.getBids();
	}
	
	@PostMapping("/bid")
	public Bid createBid(@RequestBody Bid bid) {
		return bidService.saveBid(bid);
	}
	
	@DeleteMapping("/bid/{id}")
	public void deleteBid(@PathVariable("id") final Integer id) {
		bidService.deleteBid(id);
	}
	
	@PutMapping("/bid/{id}")
	public Bid updateBid(@PathVariable("id") final Integer id, @RequestBody Bid bid) {
		Optional<Bid> e = bidService.getBid(id);
		if(e.isPresent()) {
			Bid currentBid = e.get();
			
			
			/*
			 * String firstName = bidList.getFirstName(); if(firstName != null) {
			 * currentBidList.setFirstName(firstName); } String lastName =
			 * bidList.getLastName(); if(lastName != null) {
			 * currentBidList.setLastName(lastName);; } String mail = bidList.getMail();
			 * if(mail != null) { currentBidList.setMail(mail); } String password =
			 * bidList.getPassword(); if(password != null) {
			 * currentBidList.setPassword(password);; }
			 */
			bidService.saveBid(currentBid);
			return currentBid;
		} else {
			return null;
		}
	}
	
	

}