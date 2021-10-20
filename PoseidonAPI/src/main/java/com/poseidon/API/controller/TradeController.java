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

import com.poseidon.API.model.Trade;
import com.poseidon.API.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@GetMapping("/trade/{id}")
	public Trade getTrade(@PathVariable("id") final Integer id) {
		Optional<Trade> trade = tradeService.getTrade(id);
		if (trade.isPresent()) {
			return trade.get();
		} else {
			return null;
		}
	}

	@GetMapping("/trades")
	public Iterable<Trade> getTrades() {
		return tradeService.getTrades();
	}

	@PostMapping("/trade")
	public Trade createTrade(@RequestBody Trade trade) {
		return tradeService.saveTrade(trade);
	}

	@DeleteMapping("/trade/{id}")
	public void deleteTrade(@PathVariable("id") final Integer id) {
		tradeService.deleteTrade(id);
	}

	@PutMapping("/trade/{id}")
	public Trade updateTrade(@PathVariable("id") final Integer id, @RequestBody Trade trade) {
		Optional<Trade> e = tradeService.getTrade(id);
		if (e.isPresent()) {
			Trade currentTrade = e.get();

			String account = trade.getAccount();
			if (account != null) {
				currentTrade.setAccount(account);
			}
			String type = trade.getType();
			if (type != null) {
				currentTrade.setType(type);
			}
			double buyQuantity = trade.getBuyQuantity();
			if (buyQuantity != 0) {
				currentTrade.setBuyQuantity(buyQuantity);
			}

			tradeService.saveTrade(currentTrade);
			return currentTrade;
		} else {
			return null;
		}
	}

}
