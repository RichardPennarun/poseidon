package com.poseidon.API.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poseidon.API.model.CurvePoint;
import com.poseidon.API.service.CurvePointService;

@RestController
public class CurvePointController {

	@Autowired
	private CurvePointService curvePointService;

	@GetMapping("/curvePoint/{id}")
	public CurvePoint getCurvePoint(@PathVariable("id") final Integer id) {
		Optional<CurvePoint> curvePoint = curvePointService.getCurvePoint(id);
		if (curvePoint.isPresent()) {
			return curvePoint.get();
		} else {
			return null;
		}
	}

	@GetMapping("/curvePoints")
	public Iterable<CurvePoint> getCurvePoints() {
		return curvePointService.getCurvePoints();
	}

	@PostMapping("/curvePoint")
	public CurvePoint createCurvePoint(@RequestBody CurvePoint curvePoint) {
		return curvePointService.saveCurvePoint(curvePoint);
	}

	@DeleteMapping("/curvePoint/{id}")
	public void deleteCurvePoint(@PathVariable("id") final Integer id) {
		curvePointService.deleteCurvePoint(id);
	}

	@PutMapping("/curvePoint/{id}")
	public CurvePoint updateCurvePoint(@PathVariable("id") final Integer id, @RequestBody CurvePoint curvePoint) {
		Optional<CurvePoint> e = curvePointService.getCurvePoint(id);
		if (e.isPresent()) {
			CurvePoint currentCurvePoint = e.get();

			int curveId = curvePoint.getCurveId();
			if (curveId != 0) {
				currentCurvePoint.setCurveId(curveId);
			}
			double term = curvePoint.getTerm();
			if (term != 0) {
				currentCurvePoint.setTerm(term);
			}
			double value = curvePoint.getValue();
			if (value != 0) {
				currentCurvePoint.setValue(value);
			}
			curvePointService.saveCurvePoint(currentCurvePoint);
			return currentCurvePoint;
		} else {
			return null;
		}
	}

}
