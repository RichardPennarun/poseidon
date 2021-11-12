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
import com.poseidon.webapp.model.Trade;
import com.poseidon.webapp.service.TradeService;

@SpringBootTest
@AutoConfigureMockMvc
public class TradeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TradeService tradeService;

	@Before
	public void setup() {

	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testGetTradeList() throws Exception {

		mockMvc.perform(get("/tradeList")).andDo(print()).andExpect(status().isOk());
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
	public void testAddTradeForm() throws Exception {

		Trade tradeToSave = new Trade();
		tradeToSave.setAccount("Rose");
		tradeToSave.setType("AAA");
		tradeToSave.setBuyQuantity(100);

		mockMvc.perform(get("/createTrade").content(asJsonString(tradeToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		MockHttpServletRequestBuilder builder = 
				post("/validateTradeAdd")
				.accept(MediaType.TEXT_HTML)
				.param("account", "Rose")
				.param("type", "AAA")
				.param("buyQuantity", "10")
				.with(csrf());

		mockMvc.perform(builder).andDo(print())
		.andExpect(model().errorCount(0)).andExpect(redirectedUrl("/tradeList"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddNotOk() throws Exception {

		MockHttpServletRequestBuilder builder = 
				post("/validateTradeAdd")
				.accept(MediaType.TEXT_HTML)
				.param("account", "")
				.param("type", "AAA")
				.param("buyQuantity", "10")
				.with(csrf());

		mockMvc.perform(builder).andDo(print())
		.andExpect(model().errorCount(1))
		.andExpect(MockMvcResultMatchers.view().name("trade/add"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void testUpdateTrade() throws Exception {

		Trade tradeToSave = new Trade();
		tradeToSave.setId(2);
		tradeToSave.setAccount("Rose");
		tradeToSave.setType("AAA");
		tradeToSave.setBuyQuantity(100);

		when(tradeService.getTrade(2)).thenReturn(tradeToSave);

		mockMvc.perform(get("/updateTrade/{id}", 2).content(asJsonString(tradeToSave))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateOk() throws Exception {

		MockHttpServletRequestBuilder builder =

				post("/validateTradeUpdate").accept(MediaType.TEXT_HTML).param("id", "2").param("account", "Rose")
						.param("type", "AAA").param("buyQuantity", "10").with(csrf());

		mockMvc.perform(builder).andDo(print()).andExpect(model().errorCount(0)).andExpect(redirectedUrl("/tradeList"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateNotOk() throws Exception {

		MockHttpServletRequestBuilder builder = post("/validateTradeUpdate").accept(MediaType.TEXT_HTML).param("id", "2")
				.param("account", "").param("type", "AAA").param("buyQuantity", "10").with(csrf());

		mockMvc.perform(builder).andDo(print()).andExpect(model().errorCount(1))
				.andExpect(MockMvcResultMatchers.view().name("trade/update"));
	}
	

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteTrade() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/deleteTrade/{id}", 2))
		.andExpect(redirectedUrl("/tradeList"));

	}
}
