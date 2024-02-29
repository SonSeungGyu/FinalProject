package com.example.demo.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.weather.entity.WeatherEntity;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer>{

}
