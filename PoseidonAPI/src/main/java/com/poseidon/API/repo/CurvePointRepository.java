package com.poseidon.API.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidon.API.model.CurvePoint;

@Repository
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

}
