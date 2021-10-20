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
		if (bid.isPresent()) {
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
		if (e.isPresent()) {
			Bid currentBid = e.get();

			String account = bid.getAccount();
			if (account != null) {
				currentBid.setAccount(account);
			}
			String type = bid.getType();
			if (type != null) {
				currentBid.setType(type);
			}
			double bidQuantity = bid.getBidQuantity();
			if (bidQuantity != 0) {
				currentBid.setBidQuantity(bidQuantity);
			}

			bidService.saveBid(currentBid);
			return currentBid;
		} else {
			return null;
		}
	}

}