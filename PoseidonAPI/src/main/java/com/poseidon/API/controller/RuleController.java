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

import com.poseidon.API.model.Rule;
import com.poseidon.API.service.RuleService;

@RestController
public class RuleController {

	@Autowired
	private RuleService ruleService;

	@GetMapping("/rule/{id}")
	public Rule getRule(@PathVariable("id") final Integer id) {
		Optional<Rule> rule = ruleService.getRule(id);
		if (rule.isPresent()) {
			return rule.get();
		} else {
			return null;
		}
	}

	@GetMapping("/rules")
	public Iterable<Rule> getRules() {
		return ruleService.getRules();
	}

	@PostMapping("/rule")
	public Rule createRule(@RequestBody Rule rule) {
		return ruleService.saveRule(rule);
	}

	@DeleteMapping("/rule/{id}")
	public void deleteRule(@PathVariable("id") final Integer id) {
		ruleService.deleteRule(id);
	}

	@PutMapping("/rule/{id}")
	public Rule updateRule(@PathVariable("id") final Integer id, @RequestBody Rule rule) {
		Optional<Rule> e = ruleService.getRule(id);
		if (e.isPresent()) {
			Rule currentRule = e.get();

			String name = rule.getName();
			if (name != null) {
				currentRule.setName(name);
			}
			String description = rule.getDescription();
			if (description != null) {
				currentRule.setDescription(description);
			}
			String json = rule.getJson();
			if (json != null) {
				currentRule.setJson(json);
			}
			String template = rule.getTemplate();
			if (template != null) {
				currentRule.setTemplate(template);
			}
			String sqlStr = rule.getSqlStr();
			if (sqlStr != null) {
				currentRule.setSqlStr(sqlStr);
			}
			String sqlPart = rule.getSqlPart();
			if (sqlPart != null) {
				currentRule.setSqlPart(sqlPart);
			}

			ruleService.saveRule(currentRule);
			return currentRule;
		} else {
			return null;
		}
	}

}
