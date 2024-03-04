package com.example.demo.court.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.court.entity.CourtEntity;
//2024-02-20 구장테이블 생성
public interface CourtRepository extends JpaRepository<CourtEntity, String>{

}
