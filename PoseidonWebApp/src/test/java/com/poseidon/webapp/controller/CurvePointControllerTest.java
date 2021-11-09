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
import com.poseidon.webapp.model.CurvePoint;
import com.poseidon.webapp.proxy.CurvePointProxy;
import com.poseidon.webapp.service.CurvePointService;

@SpringBootTest
@AutoConfigureMockMvc
public class CurvePointControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CurvePointProxy curvePointProxy;

	@MockBean
	private CurvePointService curvePointService;

	@Before
	public void setup() {

	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testGetCurvePointList() throws Exception {

		mockMvc.perform(get("/curvePointList")).andDo(print()).andExpect(status().isOk());
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
	public void testAddCurvePointForm() throws Exception {

		CurvePoint curvePointToSave = new CurvePoint();
		curvePointToSave.setCurveId(55);
		curvePointToSave.setTerm(5);
		curvePointToSave.setValue(100);

		mockMvc.perform(get("/createCurvePoint").content(asJsonString(curvePointToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		CurvePoint curvePointToSave = new CurvePoint();
		curvePointToSave.setCurveId(55);
		curvePointToSave.setTerm(5);
		curvePointToSave.setValue(100);

		when(curvePointService.saveCurvePoint(curvePointToSave)).thenReturn(curvePointToSave);

		mockMvc.perform(post("/validateCurvePointAdd").content(asJsonString(curvePointToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/curvePointList"));
	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testUpdateCurvePoint() throws Exception {

		CurvePoint curvePointToSave = new CurvePoint();
		curvePointToSave.setId(2);
		curvePointToSave.setCurveId(55);
		curvePointToSave.setTerm(5);
		curvePointToSave.setValue(100);

		when(curvePointService.getCurvePoint(2)).thenReturn(curvePointToSave);

		mockMvc.perform(get("/updateCurvePoint/{id}", 2).content(asJsonString(curvePointToSave))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateOk() throws Exception {

		CurvePoint curvePointToSave = new CurvePoint();
		curvePointToSave.setCurveId(55);
		curvePointToSave.setTerm(5);
		curvePointToSave.setValue(100);

		when(curvePointService.saveCurvePoint(curvePointToSave)).thenReturn(curvePointToSave);

		mockMvc.perform(post("/validateCurvePointUpdate").content(asJsonString(curvePointToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/curvePointList"));
	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteCurvePoint() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/deleteCurvePoint/{id}", 2))
		.andExpect(redirectedUrl("/curvePointList"));

	}
}
