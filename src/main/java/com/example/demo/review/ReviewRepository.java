package com.example.demo.review;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.review.entity.ReviewEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{

}
