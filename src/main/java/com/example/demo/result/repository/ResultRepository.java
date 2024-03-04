package com.example.demo.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.result.entity.ResultEntity;
//2024-02-20 결과테이블 생성
public interface ResultRepository extends JpaRepository<ResultEntity, Integer>{

}
