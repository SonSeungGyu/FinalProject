package com.example.demo.weather.service;

import java.util.List;

import com.example.demo.weather.entity.WeatherEntity;

public interface WeatherService {
	void upload(List<WeatherEntity> weatherList);
}
