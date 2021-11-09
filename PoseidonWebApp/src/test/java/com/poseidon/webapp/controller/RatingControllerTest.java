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
import com.poseidon.webapp.model.Rating;
import com.poseidon.webapp.proxy.RatingProxy;
import com.poseidon.webapp.service.RatingService;

@SpringBootTest
@AutoConfigureMockMvc
public class RatingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RatingProxy ratingProxy;

	@MockBean
	private RatingService ratingService;

	@Before
	public void setup() {

	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testGetRatingList() throws Exception {

		mockMvc.perform(get("/ratingList")).andDo(print()).andExpect(status().isOk());
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
	public void testAddRatingForm() throws Exception {

		Rating ratingToSave = new Rating();
		ratingToSave.setMoodysRating("oui");
		ratingToSave.setSAndPRating("non");
		ratingToSave.setFitchRating("nspp");
		ratingToSave.setOrderNumber(55);

		mockMvc.perform(get("/createRating").content(asJsonString(ratingToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		Rating ratingToSave = new Rating();
		ratingToSave.setMoodysRating("oui");
		ratingToSave.setSAndPRating("non");
		ratingToSave.setFitchRating("nspp");
		ratingToSave.setOrderNumber(55);

		when(ratingService.saveRating(ratingToSave)).thenReturn(ratingToSave);

		mockMvc.perform(post("/validateRatingAdd").content(asJsonString(ratingToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/ratingList"));
	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testUpdateRating() throws Exception {

		Rating ratingToSave = new Rating();
		ratingToSave.setId(2);
		ratingToSave.setMoodysRating("oui");
		ratingToSave.setSAndPRating("non");
		ratingToSave.setFitchRating("nspp");
		ratingToSave.setOrderNumber(55);

		when(ratingService.getRating(2)).thenReturn(ratingToSave);

		mockMvc.perform(get("/updateRating/{id}", 2).content(asJsonString(ratingToSave))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateOk() throws Exception {

		Rating ratingToSave = new Rating();
		ratingToSave.setMoodysRating("oui");
		ratingToSave.setSAndPRating("non");
		ratingToSave.setFitchRating("nspp");
		ratingToSave.setOrderNumber(55);

		when(ratingService.saveRating(ratingToSave)).thenReturn(ratingToSave);

		mockMvc.perform(post("/validateRatingUpdate").content(asJsonString(ratingToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/ratingList"));
	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteRating() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/deleteRating/{id}", 2))
		.andExpect(redirectedUrl("/ratingList"));

	}
}
