package com.poseidon.webapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.webapp.model.Bid;
import com.poseidon.webapp.service.BidService;

@SpringBootTest
@AutoConfigureMockMvc
public class BidControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BidService bidService;

	@BeforeEach
	public void setup() {

	}


	@Test
	@WithMockUser(username = "user", password = "1")
	public void testGetBidList() throws Exception {

		mockMvc.perform(get("/bidList")).andDo(print()).andExpect(status().isOk());
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
	public void testAddBidForm() throws Exception {

		Bid bidToSave = new Bid();
		bidToSave.setAccount("Rose");
		bidToSave.setType("AAA");
		bidToSave.setBidQuantity(100);

		mockMvc.perform(get("/createBid").content(asJsonString(bidToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		MockHttpServletRequestBuilder builder = 
				post("/validateBidAdd")
				.accept(MediaType.TEXT_HTML)
				.param("account", "Rose")
				.param("type", "AAA")
				.param("bidQuantity", "10")
				.with(csrf());

		mockMvc.perform(builder).andDo(print())
		.andExpect(model().errorCount(0)).andExpect(redirectedUrl("/bidList"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddNotOk() throws Exception {

		MockHttpServletRequestBuilder builder =

				post("/validateBidAdd").accept(MediaType.TEXT_HTML).param("account", "").param("type", "AAA")
						.param("bidQuantity", "10").with(csrf());

		mockMvc.perform(builder).andDo(print()).andExpect(model().errorCount(1))
				.andExpect(MockMvcResultMatchers.view().name("bid/add"));
	}


	@Test
	@WithMockUser(username = "user", password = "1")
	public void testUpdateBid() throws Exception {

		Bid bidToSave = new Bid();
		bidToSave.setId(2);
		bidToSave.setAccount("Rose");
		bidToSave.setType("AAA");
		bidToSave.setBidQuantity(100);

		when(bidService.getBid(2)).thenReturn(bidToSave);

		mockMvc.perform(get("/updateBid/{id}", 2).content(asJsonString(bidToSave))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateOk() throws Exception {

		MockHttpServletRequestBuilder builder =

				post("/validateBidUpdate").accept(MediaType.TEXT_HTML).param("id", "2").param("account", "Rose")
						.param("type", "AAA").param("bidQuantity", "10").with(csrf());

		mockMvc.perform(builder).andDo(print()).andExpect(model().errorCount(0)).andExpect(redirectedUrl("/bidList"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateNotOk() throws Exception {

		MockHttpServletRequestBuilder builder = post("/validateBidUpdate").accept(MediaType.TEXT_HTML).param("id", "2")
				.param("account", "").param("type", "AAA").param("bidQuantity", "10").with(csrf());

		mockMvc.perform(builder).andDo(print()).andExpect(model().errorCount(1))
				.andExpect(MockMvcResultMatchers.view().name("bid/update"));
	}

	
	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteBid() throws Exception {

		mockMvc.perform(get("/deleteBid/{id}", 2)).andExpect(redirectedUrl("/bidList"));

	}

}