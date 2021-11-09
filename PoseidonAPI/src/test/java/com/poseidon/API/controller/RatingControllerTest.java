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
import com.poseidon.API.model.Rating;
import com.poseidon.API.service.RatingService;


@WebMvcTest(controllers = RatingController.class)
public class RatingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RatingService ratingService;


	//@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testGetRatings() throws Exception {
		mockMvc.perform(get("/ratings")).andExpect(status().isOk());
	}


	@Test
	public void testGetRating() throws Exception {
		mockMvc.perform(get("/rating/{id}", 2)).andExpect(status().isOk());
	}


	@Test
	public void testDeleteRating() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/rating/{id}", 2)).andExpect(status().isOk());
	}

	@Test
	public void testCreate() throws Exception {
		  mockMvc.perform(post("/rating")
			      .content(asJsonString(new Rating()))
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
	public void testUpdateRating() throws Exception {
		Optional<Rating> rating = Optional.of(new Rating());
		Rating ratingToSave = new Rating();
		ratingToSave.setMoodysRating("oui");
		ratingToSave.setSAndPRating("non");
		ratingToSave.setFitchRating("nspp");
		ratingToSave.setOrderNumber(55);
		
		when(ratingService.getRating(2)).thenReturn(rating);
		when(ratingService.saveRating(ratingToSave)).thenReturn(ratingToSave);
		
		mockMvc.perform(put("/rating/{id}", 2)
				.content(asJsonString(ratingToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.moodysRating", is("oui")))
				.andExpect(jsonPath("$.fitchRating", is("nspp")))
				.andExpect(jsonPath("$.orderNumber", is(55)));
	}

	
}
