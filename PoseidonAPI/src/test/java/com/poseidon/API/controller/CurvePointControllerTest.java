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
import com.poseidon.API.model.CurvePoint;
import com.poseidon.API.service.CurvePointService;


@WebMvcTest(controllers = CurvePointController.class)
public class CurvePointControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CurvePointService curvePointService;


	//@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testGetCurvePoints() throws Exception {
		mockMvc.perform(get("/curvePoints")).andExpect(status().isOk());
	}


	@Test
	public void testGetCurvePoint() throws Exception {
		mockMvc.perform(get("/curvePoint/{id}", 2)).andExpect(status().isOk());
	}


	@Test
	public void testDeleteCurvePoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/curvePoint/{id}", 2)).andExpect(status().isOk());
	}

	@Test
	public void testCreate() throws Exception {
		  mockMvc.perform(post("/curvePoint")
			      .content(asJsonString(new CurvePoint()))
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
	public void testUpdateCurvePoint() throws Exception {
		Optional<CurvePoint> curvePoint = Optional.of(new CurvePoint());
		CurvePoint curvePointToSave = new CurvePoint();
		curvePointToSave.setCurveId(55);
		curvePointToSave.setTerm(5);
		curvePointToSave.setValue(100);
		
		when(curvePointService.getCurvePoint(2)).thenReturn(curvePoint);
		when(curvePointService.saveCurvePoint(curvePointToSave)).thenReturn(curvePointToSave);
		
		mockMvc.perform(put("/curvePoint/{id}", 2)
				.content(asJsonString(curvePointToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.curveId", is(55)))
				.andExpect(jsonPath("$.term", is(5.0)))
				.andExpect(jsonPath("$.value", is(100.0)));
	}
	
}
