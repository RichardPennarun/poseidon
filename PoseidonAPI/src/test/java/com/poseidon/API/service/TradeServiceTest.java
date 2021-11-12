package com.poseidon.API.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.API.model.Trade;

@SpringBootTest
public class TradeServiceTest {

	@Autowired
	private TradeService tradeService;

	@Before
	private void setUp() {
		tradeService = new TradeService();
	}

	@Test
	public void tradeServiceTest() {
		Trade tradeToSave = new Trade();
		tradeToSave.setAccount("Adam");
		tradeToSave.setType("AAA");
		tradeToSave.setBuyQuantity(100);

		Trade createdTrade = tradeService.saveTrade(tradeToSave);
		assertThat(createdTrade).isEqualTo(tradeToSave);

		tradeService.getTrades();
		
		tradeService.getTrade(createdTrade.getId());
		
		tradeService.deleteTrade(createdTrade.getId());
		
	}
}
