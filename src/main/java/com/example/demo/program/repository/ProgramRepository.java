package com.example.demo.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.program.entity.ProgramEntity;

public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer>{

}
