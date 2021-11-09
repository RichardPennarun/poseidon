package com.poseidon.API.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.API.model.Bid;

@SpringBootTest
public class BidServiceTest {

	@Autowired
	private BidService bidService;

	@Before
	private void setUp() {
		bidService = new BidService();
	}

	@Test
	public void bidServiceTest() {
		Bid bidToSave = new Bid();
		bidToSave.setAccount("Adam");
		bidToSave.setType("AAA");
		bidToSave.setBidQuantity(100);

		Bid createdBid = bidService.saveBid(bidToSave);
		assertThat(createdBid).isEqualTo(bidToSave);

		bidService.getBids();
		
		bidService.getBid(createdBid.getId());
		
		bidService.deleteBid(createdBid.getId());
		
	}
}
