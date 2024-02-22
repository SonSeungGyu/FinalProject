package com.example.demo.courtTest;

import java.util.List;

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
		CourtEntity entity = CourtEntity.builder()
							.courtName("남동")
							.courtAddress("구월동")
							.build();
		repository.save(entity);
	}
	
	@Test
	public void 구장검색() {
		List<CourtEntity> list = repository.findAll();
		for(CourtEntity entity : list) {
			System.out.println(entity);
		}
	}
}
