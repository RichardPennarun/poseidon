package com.poseidon.webapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.webapp.model.Rule;
import com.poseidon.webapp.service.RuleService;

@SpringBootTest
@AutoConfigureMockMvc
public class RuleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RuleService ruleService;

	@Before
	public void setup() {

	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testGetRuleList() throws Exception {

		mockMvc.perform(get("/ruleList")).andDo(print()).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testAddRuleForm() throws Exception {

		Rule ruleToSave = new Rule();
		ruleToSave.setName("a");
		ruleToSave.setDescription("b");
		ruleToSave.setJson("c");
		ruleToSave.setTemplate("d");
		ruleToSave.setSqlStr("e");
		ruleToSave.setSqlPart("f");

		mockMvc.perform(get("/createRule").content(asJsonString(ruleToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		MockHttpServletRequestBuilder builder = 
				post("/validateRuleAdd")
				.accept(MediaType.TEXT_HTML)
				.param("name", "a")
				.param("description", "b")
				.param("json", "c")
				.param("template", "d")
				.param("sqlStr", "e")
				.param("sqlPart", "f")
				.with(csrf());

		mockMvc.perform(builder).andDo(print())
		.andExpect(model().errorCount(0)).andExpect(redirectedUrl("/ruleList"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddNotOk() throws Exception {

		MockHttpServletRequestBuilder builder = 
				post("/validateRuleAdd")
				.accept(MediaType.TEXT_HTML)
				.param("name", "")
				.param("description", "b")
				.param("json", "c")
				.param("template", "d")
				.param("sqlStr", "e")
				.param("sqlPart", "f")
				.with(csrf());

		mockMvc.perform(builder).andDo(print())
		.andExpect(model().errorCount(1))
		.andExpect(MockMvcResultMatchers.view().name("rule/add"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void testUpdateRule() throws Exception {

		Rule ruleToSave = new Rule();
		ruleToSave.setId(2);
		ruleToSave.setName("a");
		ruleToSave.setDescription("b");
		ruleToSave.setJson("c");
		ruleToSave.setTemplate("d");
		ruleToSave.setSqlStr("e");
		ruleToSave.setSqlPart("f");

		when(ruleService.getRule(2)).thenReturn(ruleToSave);

		mockMvc.perform(get("/updateRule/{id}", 2).content(asJsonString(ruleToSave))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateOk() throws Exception {

		MockHttpServletRequestBuilder builder = 
				post("/validateRuleUpdate")
				.accept(MediaType.TEXT_HTML)
				.param("id", "22")
				.param("name", "a")
				.param("description", "b")
				.param("json", "c")
				.param("template", "d")
				.param("sqlStr", "e")
				.param("sqlPart", "f")
				.with(csrf());

		mockMvc.perform(builder).andDo(print())
		.andExpect(model().errorCount(0)).andExpect(redirectedUrl("/ruleList"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateNotOk() throws Exception {

		MockHttpServletRequestBuilder builder = 
				post("/validateRuleUpdate")
				.accept(MediaType.TEXT_HTML)
				.param("id", "22")
				.param("name", "")
				.param("description", "b")
				.param("json", "c")
				.param("template", "d")
				.param("sqlStr", "e")
				.param("sqlPart", "f")
				.with(csrf());

		mockMvc.perform(builder).andDo(print())
		.andExpect(model().errorCount(1))
		.andExpect(MockMvcResultMatchers.view().name("rule/update"));
	}
	

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteRule() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/deleteRule/{id}", 2))
		.andExpect(redirectedUrl("/ruleList"));

	}
}
