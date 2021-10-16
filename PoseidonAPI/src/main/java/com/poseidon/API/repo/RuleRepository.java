package com.poseidon.API.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidon.API.model.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer> {
}
