package com.example.demo.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.trainer.entity.TrainerEntity;

public interface TrainerRepository extends JpaRepository<TrainerEntity, String>{

}
