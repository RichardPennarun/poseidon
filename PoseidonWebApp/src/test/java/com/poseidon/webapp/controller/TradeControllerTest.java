package com.poseidon.webapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.webapp.model.Trade;
import com.poseidon.webapp.proxy.TradeProxy;
import com.poseidon.webapp.service.TradeService;

@SpringBootTest
@AutoConfigureMockMvc
public class TradeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TradeProxy tradeProxy;

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

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		Trade tradeToSave = new Trade();
		tradeToSave.setAccount("Rose");
		tradeToSave.setType("AAA");
		tradeToSave.setBuyQuantity(100);

		when(tradeService.saveTrade(tradeToSave)).thenReturn(tradeToSave);

		mockMvc.perform(post("/validateTradeAdd").content(asJsonString(tradeToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/tradeList"));
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

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateOk() throws Exception {

		Trade tradeToSave = new Trade();
		tradeToSave.setAccount("Rose");
		tradeToSave.setType("AAA");
		tradeToSave.setBuyQuantity(100);

		when(tradeService.saveTrade(tradeToSave)).thenReturn(tradeToSave);

		mockMvc.perform(post("/validateTradeUpdate").content(asJsonString(tradeToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/tradeList"));
	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteTrade() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/deleteTrade/{id}", 2))
		.andExpect(redirectedUrl("/tradeList"));

	}
}
