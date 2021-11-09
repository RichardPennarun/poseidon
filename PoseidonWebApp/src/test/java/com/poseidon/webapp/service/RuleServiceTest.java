package com.poseidon.webapp.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.webapp.model.Rule;
import com.poseidon.webapp.model.Rule;

@SpringBootTest
public class RuleServiceTest {
	

    @Autowired
    private RuleService ruleService;

    @Before
    public void setUp() {
		ruleService = new RuleService();
    }


	@Test
	public void ruleServiceTest() {
		Rule ruleToSave = new Rule();
		ruleToSave.setName("Adam");
		ruleToSave.setDescription("ok");
		ruleToSave.setJson("a");
		ruleToSave.setTemplate("b");
		ruleToSave.setSqlStr("c");
		ruleToSave.setSqlPart("d");

		Rule createdRule = ruleService.saveRule(ruleToSave);
		//assertThat(createdRule).isEqualTo(ruleToSave);

		ruleService.getRules();
		
		ruleService.getRule(createdRule.getId());
		
		ruleService.saveRule(createdRule);
		
		ruleService.deleteRule(createdRule.getId());
		
	}
	
	
	
	
}
