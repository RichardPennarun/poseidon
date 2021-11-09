package com.poseidon.webapp.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.webapp.model.Trade;
import com.poseidon.webapp.model.Trade;

@SpringBootTest
public class TradeServiceTest {
	

    @Autowired
    private TradeService tradeService;

    @Before
    public void setUp() {
		tradeService = new TradeService();
    }


	@Test
	public void tradeServiceTest() {
		Trade tradeToSave = new Trade();
		tradeToSave.setAccount("Adam");
		tradeToSave.setType("AAA");
		tradeToSave.setBuyQuantity(100);

		Trade createdTrade = tradeService.saveTrade(tradeToSave);
		//assertThat(createdTrade).isEqualTo(tradeToSave);

		tradeService.getTrades();
		
		tradeService.getTrade(createdTrade.getId());
		
		tradeService.saveTrade(createdTrade);
		
		tradeService.deleteTrade(createdTrade.getId());
		
	}
	
	
	
	
}
