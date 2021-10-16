package com.poseidon.API.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.API.model.Rule;
import com.poseidon.API.repo.RuleRepository;

@Service
public class RuleService {
	
	@Autowired
	private RuleRepository ruleRepository;
	
	public Optional<Rule> getRule(final Integer id) {
		return ruleRepository.findById(id);
	}
	
	public Iterable<Rule> getRules() {
		return ruleRepository.findAll();
	}
	
	public void deleteRule(final Integer id) {
		ruleRepository.deleteById(id);
	}
	
	public Rule saveRule(Rule rule) {
		Rule savedRule = ruleRepository.save(rule);
		return savedRule;
	}

}
