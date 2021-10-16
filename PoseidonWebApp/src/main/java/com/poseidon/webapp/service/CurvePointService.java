package com.poseidon.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.webapp.model.CurvePoint;
import com.poseidon.webapp.proxy.CurvePointProxy;

@Service
public class CurvePointService {

    @Autowired
    private CurvePointProxy curvePointProxy;

	
    public Iterable<CurvePoint> getCurvePoints() {
        return curvePointProxy.getCurvePoints();
    }
	
	public CurvePoint getCurvePoint(final int id) {
		return curvePointProxy.getCurvePoint(id);
	}
	
	public void deleteCurvePoint(final int id) {
		curvePointProxy.deleteCurvePoint(id);
	}
	
	public CurvePoint saveCurvePoint(CurvePoint curvePoint) {
		CurvePoint savedCurvePoint;

		if(curvePoint.getId() == 0) {
			savedCurvePoint = curvePointProxy.createCurvePoint(curvePoint);
		} else {
			savedCurvePoint = curvePointProxy.updateCurvePoint(curvePoint);
		}
		
		return savedCurvePoint;
	}

}
