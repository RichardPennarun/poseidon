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
import com.poseidon.API.model.Bid;
import com.poseidon.API.service.BidService;



@WebMvcTest(controllers = BidController.class)
public class BidControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BidService bidService;


	//@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testGetBids() throws Exception {
		mockMvc.perform(get("/bids")).andExpect(status().isOk());
	}


	@Test
	public void testGetBid() throws Exception {
		mockMvc.perform(get("/bid/{id}", 2)).andExpect(status().isOk());
	}


	@Test
	public void testDeleteBid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/bid/{id}", 2))
		.andExpect(status().isOk());
	}

	@Test
	public void testCreate() throws Exception {
		  mockMvc.perform(post("/bid")
			      .content(asJsonString(new Bid()))
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
	public void testUpdateBid() throws Exception {
		Optional<Bid> bid = Optional.of(new Bid());
		Bid bidToSave = new Bid();
		bidToSave.setAccount("Rose");
		bidToSave.setType("AAA");
		bidToSave.setBidQuantity(100);
		
		when(bidService.getBid(2)).thenReturn(bid);
		when(bidService.saveBid(bidToSave)).thenReturn(bidToSave);
		
		mockMvc.perform(put("/bid/{id}", 2)
				.content(asJsonString(bidToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.account", is("Rose")))
				.andExpect(jsonPath("$.type", is("AAA")))
				.andExpect(jsonPath("$.bidQuantity", is(100.0)));
	}
	
}
