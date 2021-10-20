package com.poseidon.webapp.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidon.webapp.model.Trade;
import com.poseidon.webapp.service.TradeService;

@Controller
public class TradeController {

	private static final Logger logger = LogManager.getLogger(TradeController.class);

	@Autowired
	private TradeService tradeService;

	@RequestMapping("/tradeList")
	public String tradeList(Model model) {
		Iterable<Trade> listTrade = tradeService.getTrades();
		model.addAttribute("trades", listTrade);
		logger.info("Return all trades list");
		return "trade/list";
	}

	@GetMapping("/createTrade")
	public String addTradeForm(Model model) {
		Trade trade = new Trade();
		model.addAttribute("trade", trade);
		logger.info("Return new trade form");
		return "trade/add";
	}

	@PostMapping("/validateTradeAdd")
	public String validateAdd(@Valid Trade trade, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "trade/add";
		}
		Trade savedTrade = tradeService.saveTrade(trade);
		logger.info("New trade added: " + savedTrade + "");
		return "redirect:/tradeList";
	}

	@GetMapping("/updateTrade/{id}")
	public String updateTrade(@PathVariable("id") Integer id, Model model) {
		Trade trade = tradeService.getTrade(id);
		model.addAttribute("trade", trade);
		logger.info("Return update form");
		return "trade/update";
	}

	@PostMapping("/validateTradeUpdate")
	public String validateUpdate(@Valid Trade trade, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "trade/update";
		}
		Trade updatedTrade = tradeService.saveTrade(trade);
		logger.info("Trade updated: " + updatedTrade + "");
		return "redirect:/tradeList";
	}

	@GetMapping("/deleteTrade/{id}")
	public String deleteTrade(@PathVariable("id") Integer id) {
		tradeService.deleteTrade(id);
		logger.info("Trade number " + id + " deleted");
		return "redirect:/tradeList";
	}

}