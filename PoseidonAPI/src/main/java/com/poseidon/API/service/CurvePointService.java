package com.poseidon.API.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.API.model.CurvePoint;
import com.poseidon.API.repo.CurvePointRepository;

@Service
public class CurvePointService {
	
	@Autowired
	private CurvePointRepository curvePointRepository;
	
	public Optional<CurvePoint> getCurvePoint(final Integer id) {
		return curvePointRepository.findById(id);
	}
	
	public Iterable<CurvePoint> getCurvePoints() {
		return curvePointRepository.findAll();
	}
	
	public void deleteCurvePoint(final Integer id) {
		curvePointRepository.deleteById(id);
	}
	
	public CurvePoint saveCurvePoint(CurvePoint curvePoint) {
		CurvePoint savedCurvePoint = curvePointRepository.save(curvePoint);
		return savedCurvePoint;
	}

}
