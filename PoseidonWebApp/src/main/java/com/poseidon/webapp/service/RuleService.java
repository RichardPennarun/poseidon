package com.poseidon.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.webapp.model.Rule;
import com.poseidon.webapp.proxy.RuleProxy;

@Service
public class RuleService {

    @Autowired
    private RuleProxy ruleProxy;

	
    public Iterable<Rule> getRules() {
        return ruleProxy.getRules();
    }
	
	public Rule getRule(final int id) {
		return ruleProxy.getRule(id);
	}
	
	public void deleteRule(final int id) {
		ruleProxy.deleteRule(id);
	}
	
	public Rule saveRule(Rule rule) {
		Rule savedRule;

		if(rule.getId() == 0) {
			savedRule = ruleProxy.createRule(rule);
		} else {
			savedRule = ruleProxy.updateRule(rule);
		}
		
		return savedRule;
	}

}
