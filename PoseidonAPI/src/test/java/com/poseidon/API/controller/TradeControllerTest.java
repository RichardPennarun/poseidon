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
import com.poseidon.API.model.Trade;
import com.poseidon.API.service.TradeService;

@WebMvcTest(controllers = TradeController.class)
public class TradeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TradeService tradeService;

	// @Before
	public void setUp() throws Exception {

	}

	@Test
	public void testGetTrades() throws Exception {
		mockMvc.perform(get("/trades")).andExpect(status().isOk());
	}

	@Test
	public void testGetTrade() throws Exception {
		mockMvc.perform(get("/trade/{id}", 2)).andExpect(status().isOk());
	}

	@Test
	public void testDeleteTrade() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/trade/{id}", 2)).andExpect(status().isOk());
	}

	@Test
	public void testCreate() throws Exception {
		mockMvc.perform(post("/trade")
				.content(asJsonString(new Trade()))
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
	public void testUpdateTrade() throws Exception {
		Optional<Trade> trade = Optional.of(new Trade());
		Trade tradeToSave = new Trade();
		tradeToSave.setAccount("Rose");
		tradeToSave.setType("AAA");
		tradeToSave.setBuyQuantity(100);
		
		when(tradeService.getTrade(2)).thenReturn(trade);
		when(tradeService.saveTrade(tradeToSave)).thenReturn(tradeToSave);
		
		mockMvc.perform(put("/trade/{id}", 2)
				.content(asJsonString(tradeToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.account", is("Rose")))
				.andExpect(jsonPath("$.type", is("AAA")))
				.andExpect(jsonPath("$.buyQuantity", is(100.0)));
	}

		
}
