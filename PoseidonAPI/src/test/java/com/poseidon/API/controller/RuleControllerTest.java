package com.poseidon.API.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.API.model.Rule;
import com.poseidon.API.service.RuleService;


@WebMvcTest(controllers = RuleController.class)
public class RuleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RuleService ruleService;


	//@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testGetRules() throws Exception {
		mockMvc.perform(get("/rules")).andExpect(status().isOk());
	}


	@Test
	public void testGetRule() throws Exception {
		mockMvc.perform(get("/rule/{id}", 2)).andExpect(status().isOk());
	}


	@Test
	public void testDeleteRule() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/rule/{id}", 2)).andExpect(status().isOk());
	}

	@Test
	public void testCreate() throws Exception {
		  mockMvc.perform(post("/rule")
			      .content(asJsonString(new Rule()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}


	@Test
	public void testUpdateRule() throws Exception {
		Optional<Rule> rule = Optional.of(new Rule());
		Rule ruleToSave = new Rule();
		ruleToSave.setName("a");
		ruleToSave.setDescription("b");
		ruleToSave.setJson("c");
		ruleToSave.setTemplate("d");
		ruleToSave.setSqlStr("e");
		ruleToSave.setSqlPart("f");
		
		when(ruleService.getRule(2)).thenReturn(rule);
		when(ruleService.saveRule(ruleToSave)).thenReturn(ruleToSave);
		
		mockMvc.perform(put("/rule/{id}", 2)
				.content(asJsonString(ruleToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("a")))
				.andExpect(jsonPath("$.description", is("b")))
				.andExpect(jsonPath("$.json", is("c")))
				.andExpect(jsonPath("$.template", is("d")))
				.andExpect(jsonPath("$.sqlStr", is("e")))
				.andExpect(jsonPath("$.sqlPart", is("f")));
	}

	
	
}