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

import com.poseidon.webapp.model.Rule;
import com.poseidon.webapp.service.RuleService;

@Controller
public class RuleController {

	private static final Logger logger = LogManager.getLogger(RuleController.class);

	@Autowired
	private RuleService ruleService;

	@RequestMapping("/ruleList")
	public String ruleList(Model model) {
		Iterable<Rule> listRule = ruleService.getRules();
		model.addAttribute("rules", listRule);
		logger.info("Return all rules list");
		return "rule/list";
	}

	@GetMapping("/createRule")
	public String addRuleForm(Model model) {
		Rule rule = new Rule();
		model.addAttribute("rule", rule);
		logger.info("Return new rule form");
		return "rule/add";
	}

	@PostMapping("/validateRuleAdd")
	public String validateAdd(@Valid Rule rule, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "rule/add";
		}
		Rule savedRule = ruleService.saveRule(rule);
		logger.info("New rule added: " + savedRule + "");
		return "redirect:/ruleList";
	}

	@GetMapping("/updateRule/{id}")
	public String updateRule(@PathVariable("id") Integer id, Model model) {
		Rule rule = ruleService.getRule(id);
		model.addAttribute("rule", rule);
		logger.info("Return update form");
		return "rule/update";
	}

	@PostMapping("/validateRuleUpdate")
	public String validateUpdate(@Valid Rule rule, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "rule/update";
		}
		Rule updatedRule = ruleService.saveRule(rule);
		logger.info("Rule updated: " + updatedRule + "");
		return "redirect:/ruleList";
	}

	@GetMapping("/deleteRule/{id}")
	public String deleteRule(@PathVariable("id") Integer id) {
		ruleService.deleteRule(id);
		logger.info("Rule number " + id + " deleted");
		return "redirect:/ruleList";
	}



}
