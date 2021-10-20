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

import com.poseidon.webapp.model.Bid;
import com.poseidon.webapp.service.BidService;

@Controller
public class BidController {

	private static final Logger logger = LogManager.getLogger(BidController.class);

	@Autowired
	private BidService bidService;

	@RequestMapping("/bidList")
	public String bidList(Model model) {
		Iterable<Bid> listBid = bidService.getBids();
		model.addAttribute("bids", listBid);
		logger.info("Return all bids list");
		return "bid/list";
	}

	@GetMapping("/createBid")
	public String addBidForm(Model model) {
		Bid bid = new Bid();
		model.addAttribute("bid", bid);
		logger.info("Return new bid form");
		return "bid/add";
	}

	@PostMapping("/validateBidAdd")
	public String validateAdd(@Valid Bid bid, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "bid/add";
		}
		Bid savedBid = bidService.saveBid(bid);
		logger.info("New bid added: " + savedBid + "");
		return "redirect:/bidList";
	}

	@GetMapping("/updateBid/{id}")
	public String updateBid(@PathVariable("id") Integer id, Model model) {
		Bid bid = bidService.getBid(id);
		model.addAttribute("bid", bid);
		logger.info("Return update form");
		return "bid/update";
	}

	@PostMapping("/validateBidUpdate")
	public String validateUpdate(@Valid Bid bid, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "bid/update";
		}
		Bid updatedBid = bidService.saveBid(bid);
		logger.info("Bid updated: " + updatedBid + "");
		return "redirect:/bidList";
	}

	@GetMapping("/deleteBid/{id}")
	public String deleteBid(@PathVariable("id") Integer id) {
		bidService.deleteBid(id);
		logger.info("Bid number " + id + " deleted");
		return "redirect:/bidList";
	}

}