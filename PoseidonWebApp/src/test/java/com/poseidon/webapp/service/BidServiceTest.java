package com.poseidon.webapp.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.poseidon.webapp.model.Bid;

@SpringBootTest
public class BidServiceTest {
	

    @Autowired
    private BidService bidService;

    @Before
    public void setUp() {
		bidService = new BidService();
    }


	@Test
	public void bidServiceTest() {
		Bid bidToSave = new Bid();
		bidToSave.setAccount("Adam");
		bidToSave.setType("AAA");
		bidToSave.setBidQuantity(100);

		Bid createdBid = bidService.saveBid(bidToSave);

		bidService.getBids();
		
		bidService.getBid(createdBid.getId());
		
		bidService.saveBid(createdBid);
		
		bidService.deleteBid(createdBid.getId());
		
	}
	
	
	
	
}
