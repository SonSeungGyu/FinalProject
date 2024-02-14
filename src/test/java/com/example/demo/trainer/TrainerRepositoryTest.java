package com.example.demo.trainer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.trainer.entity.TrainerEntity;
import com.example.demo.trainer.repository.TrainerRepository;

@SpringBootTest
public class TrainerRepositoryTest {
	@Autowired
	TrainerRepository repository;
	
	@Test
	public void 트레이너등록() {
		TrainerEntity trainerEntity = TrainerEntity.builder().trainerId("admin").trainerName("석준").trainerPassword("1234").build();
		repository.save(trainerEntity);
	}
}
