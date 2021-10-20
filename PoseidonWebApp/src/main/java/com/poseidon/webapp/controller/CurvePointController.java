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

import com.poseidon.webapp.model.CurvePoint;
import com.poseidon.webapp.service.CurvePointService;

@Controller
public class CurvePointController {

	private static final Logger logger = LogManager.getLogger(CurvePointController.class);

	@Autowired
	private CurvePointService curvePointService;

	@RequestMapping("/curvePointList")
	public String curvePointList(Model model) {
		Iterable<CurvePoint> listCurvePoint = curvePointService.getCurvePoints();
		model.addAttribute("curvePoints", listCurvePoint);
		logger.info("Return all curvePoints list");
		return "curvePoint/list";
	}

	@GetMapping("/createCurvePoint")
	public String addCurvePointForm(Model model) {
		CurvePoint curvePoint = new CurvePoint();
		model.addAttribute("curvePoint", curvePoint);
		logger.info("Return new curvePoint form");
		return "curvePoint/add";
	}

	@PostMapping("/validateCurvePointAdd")
	public String validateAdd(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "curvePoint/add";
		}
		CurvePoint savedCurvePoint = curvePointService.saveCurvePoint(curvePoint);
		logger.info("New curvePoint added: " + savedCurvePoint + "");
		return "redirect:/curvePointList";
	}

	@GetMapping("/updateCurvePoint/{id}")
	public String updateCurvePoint(@PathVariable("id") Integer id, Model model) {
		CurvePoint curvePoint = curvePointService.getCurvePoint(id);
		model.addAttribute("curvePoint", curvePoint);
		logger.info("Return update form");
		return "curvePoint/update";
	}

	@PostMapping("/validateCurvePointUpdate")
	public String validateUpdate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "curvePoint/update";
		}
		CurvePoint updatedCurvePoint = curvePointService.saveCurvePoint(curvePoint);
		logger.info("CurvePoint updated: " + updatedCurvePoint + "");
		return "redirect:/curvePointList";
	}

	@GetMapping("/deleteCurvePoint/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id) {
		curvePointService.deleteCurvePoint(id);
		logger.info("CurvePoint number " + id + " deleted");
		return "redirect:/curvePointList";
	}

}