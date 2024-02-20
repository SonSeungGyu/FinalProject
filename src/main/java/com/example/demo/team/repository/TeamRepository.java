package com.example.demo.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity,Integer> {

}
