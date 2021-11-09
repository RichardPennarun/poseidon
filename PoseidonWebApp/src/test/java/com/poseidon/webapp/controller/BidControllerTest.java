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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.webapp.model.Bid;
import com.poseidon.webapp.proxy.BidProxy;
import com.poseidon.webapp.service.BidService;

@SpringBootTest
@AutoConfigureMockMvc
public class BidControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BidProxy bidProxy;

	@MockBean
	private BidService bidService;

	@Before
	public void setup() {

	}

	@Disabled
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

	@Disabled
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

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		Bid bidToSave = new Bid();
		bidToSave.setAccount("Rose");
		bidToSave.setType("AAA");
		bidToSave.setBidQuantity(100);

		when(bidService.saveBid(bidToSave)).thenReturn(bidToSave);

		mockMvc.perform(post("/validateBidAdd").content(asJsonString(bidToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(redirectedUrl("/bidList"));
	}

	@Disabled
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

		Bid bidToSave = new Bid();
		bidToSave.setAccount("Rose");
		bidToSave.setType("AAA");
		bidToSave.setBidQuantity(100);

		//when(bidService.saveBid(bidToSave)).thenReturn(bidToSave);

		mockMvc.perform(MockMvcRequestBuilders.post("/validateBidUpdate")
				.content(asJsonString(bidToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(redirectedUrl("/bidList"));
	}

	
	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteBid() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/deleteBid/{id}", 2))
		.andExpect(redirectedUrl("/bidList"));

	}

	// .andExpect(model().attribute("bids", bids))
	// .andExpect(view().name("bid/list"));
	// .attribute("msg", "Hi there, Joe."))
	// .andExpect(MockMvcResultMatchers.view().name("hello-page"));

	/*
	 * @Test public void testGetBidList() throws Exception {
	 * mockMvc.perform(get("/bidList")) .andDo(print())
	 * //.andExpect(status().isOk()) .andExpect(view().name("bid/list"))
	 * .andExpect(content().string(containsString("Laurent"))); }
	 */

	/*
	 * @Test public void testbidList() throws Exception {
	 * 
	 * List<Bid> bids = new ArrayList<Bid>(); Bid bid = new Bid();
	 * bid.setAccount("Adamito"); bid.setType("A"); bid.setBidQuantity(100);
	 * bids.add(bid);
	 * 
	 * when(bidService.getBids()).thenReturn((Iterable<Bid>) bids);
	 * 
	 * mockMvc.perform(get("/bidList")) .andDo(print())
	 * //.andExpect(status().isOk()) .andExpect(view().name("bid/list"))
	 * .andExpect(model().attribute("bids", bids)); }
	 */

	/*
	 * @Test public void testValidateAdd() throws Exception {
	 * mockMvc.perform(post("/validateBidAdd") .content(asJsonString(new Bid()))
	 * .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
	 * .andDo(print()) .andExpect(status().isOk())
	 * .andExpect(view().name("bid/list")); }
	 * 
	 * 
	 * public static String asJsonString(final Object obj) { try { return new
	 * ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
	 * RuntimeException(e); }
	 * 
	 * }
	 */
}