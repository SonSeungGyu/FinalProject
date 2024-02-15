package com.example.demo.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.program.entity.ProgramEntity;
import com.example.demo.review.entity.ReviewEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{

	List<ReviewEntity> findByProgram (ProgramEntity program);
	
	void deleteByProgram (ProgramEntity program);
}
