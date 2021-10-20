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

import com.poseidon.webapp.model.Rating;
import com.poseidon.webapp.service.RatingService;

@Controller
public class RatingController {

	private static final Logger logger = LogManager.getLogger(RatingController.class);

	@Autowired
	private RatingService ratingService;

	@RequestMapping("/ratingList")
	public String ratingList(Model model) {
		Iterable<Rating> listRating = ratingService.getRatings();
		model.addAttribute("ratings", listRating);
		logger.info("Return all ratings list");
		return "rating/list";
	}

	@GetMapping("/createRating")
	public String addRatingForm(Model model) {
		Rating rating = new Rating();
		model.addAttribute("rating", rating);
		logger.info("Return new rating form");
		return "rating/add";
	}

	@PostMapping("/validateRatingAdd")
	public String validateAdd(@Valid Rating rating, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "rating/add";
		}
		Rating savedRating = ratingService.saveRating(rating);
		logger.info("New rating added: " + savedRating + "");
		return "redirect:/ratingList";
	}

	@GetMapping("/updateRating/{id}")
	public String updateRating(@PathVariable("id") Integer id, Model model) {
		Rating rating = ratingService.getRating(id);
		model.addAttribute("rating", rating);
		logger.info("Return update form");
		return "rating/update";
	}

	@PostMapping("/validateRatingUpdate")
	public String validateUpdate(@Valid Rating rating, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "rating/update";
		}
		Rating updatedRating = ratingService.saveRating(rating);
		logger.info("Rating updated: " + updatedRating + "");
		return "redirect:/ratingList";
	}

	@GetMapping("/deleteRating/{id}")
	public String deleteRating(@PathVariable("id") Integer id) {
		ratingService.deleteRating(id);
		logger.info("Rating number " + id + " deleted");
		return "redirect:/ratingList";
	}

}


