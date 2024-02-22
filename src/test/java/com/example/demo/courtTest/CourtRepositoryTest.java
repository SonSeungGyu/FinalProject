package com.example.demo.courtTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.court.entity.CourtEntity;
import com.example.demo.court.repository.CourtRepository;

@SpringBootTest
public class CourtRepositoryTest {
	@Autowired
	CourtRepository repository;
	@Test
	public void 구장등록() {
		CourtEntity entity = CourtEntity.builder().courtName("서창풋살장").courtAddress("서창동").build();
		repository.save(entity);
	}
}
