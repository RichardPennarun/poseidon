package com.poseidon.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.webapp.model.Trade;
import com.poseidon.webapp.proxy.TradeProxy;

@Service
public class TradeService {

    @Autowired
    private TradeProxy tradeProxy;

	
    public Iterable<Trade> getTrades() {
        return tradeProxy.getTrades();
    }
	
	public Trade getTrade(final int id) {
		return tradeProxy.getTrade(id);
	}
	
	public void deleteTrade(final int id) {
		tradeProxy.deleteTrade(id);
	}
	
	public Trade saveTrade(Trade trade) {
		Trade savedTrade;

		if(trade.getId() == 0) {
			savedTrade = tradeProxy.createTrade(trade);
		} else {
			savedTrade = tradeProxy.updateTrade(trade);
		}
		
		return savedTrade;
	}

}
