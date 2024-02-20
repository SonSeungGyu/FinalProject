package com.example.demo.waitingMatching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.waitingMatching.entity.WaitingMatchingEntity;
//2024-02-20 대기매칭테이블 생성
public interface WaitingMatchingRepository extends JpaRepository<WaitingMatchingEntity, Integer>{

}
