package com.poseidon.API.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.API.model.Trade;
import com.poseidon.API.repo.TradeRepository;

@Service
public class TradeService {
	
	@Autowired
	private TradeRepository tradeRepository;
	
	public Optional<Trade> getTrade(final Integer id) {
		return tradeRepository.findById(id);
	}
	
	public Iterable<Trade> getTrades() {
		return tradeRepository.findAll();
	}
	
	public void deleteTrade(final Integer id) {
		tradeRepository.deleteById(id);
	}
	
	public Trade saveTrade(Trade trade) {
		Trade savedTrade = tradeRepository.save(trade);
		return savedTrade;
	}

}
