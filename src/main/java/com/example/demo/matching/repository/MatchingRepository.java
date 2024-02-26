package com.example.demo.matching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.matching.entity.MatchingEntity;

public interface MatchingRepository extends JpaRepository<MatchingEntity, Integer>{
	
}
