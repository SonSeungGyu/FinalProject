package com.example.demo.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.review.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{

}
