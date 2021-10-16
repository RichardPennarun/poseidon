package com.poseidon.API.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidon.API.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

}
