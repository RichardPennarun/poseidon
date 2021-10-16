package com.poseidon.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.webapp.model.Bid;
import com.poseidon.webapp.proxy.BidProxy;

@Service
public class BidService {

    @Autowired
    private BidProxy bidProxy;

	
    public Iterable<Bid> getBids() {
        return bidProxy.getBids();
    }
	
	public Bid getBid(final int id) {
		return bidProxy.getBid(id);
	}
	
	public void deleteBid(final int id) {
		bidProxy.deleteBid(id);
	}
	
	public Bid saveBid(Bid bid) {
		Bid savedBid;

		if(bid.getId() == 0) {
			savedBid = bidProxy.createBid(bid);
		} else {
			savedBid = bidProxy.updateBid(bid);
		}
		
		return savedBid;
	}

}
