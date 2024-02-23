package com.example.demo.matching.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.matching.dto.MatchingDto;
import com.example.demo.matching.entity.MatchingEntity;

public interface MatchingRepository extends JpaRepository<MatchingEntity, Integer>{
	List<MatchingDto> findByMatchStatus(String matchStatus);
}
