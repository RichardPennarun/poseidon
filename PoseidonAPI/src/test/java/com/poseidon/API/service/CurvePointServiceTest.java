package com.poseidon.API.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.API.model.CurvePoint;

@SpringBootTest
public class CurvePointServiceTest {

	@Autowired
	private CurvePointService curvePointService;

	@Before
	private void setUp() {
		curvePointService = new CurvePointService();
	}

	@Test
	public void curvePointServiceTest() {
		CurvePoint curvePointToSave = new CurvePoint();
		curvePointToSave.setCurveId(99);
		curvePointToSave.setTerm(5.0);
		curvePointToSave.setValue(10.0);

		CurvePoint createdCurvePoint = curvePointService.saveCurvePoint(curvePointToSave);
		assertThat(createdCurvePoint).isEqualTo(curvePointToSave);

		curvePointService.getCurvePoints();
		
		curvePointService.getCurvePoint(createdCurvePoint.getId());
		
		curvePointService.deleteCurvePoint(createdCurvePoint.getId());
		
	}
}
