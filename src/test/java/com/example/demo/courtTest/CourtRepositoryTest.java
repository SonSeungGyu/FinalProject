package com.example.demo.courtTest;

import java.util.ArrayList;
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
		List<CourtEntity> list = new ArrayList<>();
		
		CourtEntity entity = CourtEntity.builder()
							.courtName("신석체육공원 풋살장")
							.courtAddress("인천 서구 석남동 222")
							.build();
		list.add(entity);
		
		CourtEntity entity1 = CourtEntity.builder()
				.courtName("청라북항풋살장")
				.courtAddress("인천 서구 원창동 381-76")
				.build();
		list.add(entity1);
	
		CourtEntity entity2 = CourtEntity.builder()
				.courtName("화동공원 풋살장")
				.courtAddress("인천 미추홀구 도화동 1007-3")
				.build();
		list.add(entity2);
		CourtEntity entity3 = CourtEntity.builder()
				.courtName("현우풋살스타디움")
				.courtAddress("인천 서구 석남동 223-192")
				.build();
		list.add(entity3);
		CourtEntity entity4 = CourtEntity.builder()
				.courtName("플랩 스타디움 인천 가좌")
				.courtAddress("인천 서구 가좌동 150-30")
				.build();
		list.add(entity4);
		CourtEntity entity5 = CourtEntity.builder()
				.courtName("FMS축구클럽")
				.courtAddress("인천 부평구 십정동 235")
				.build();
		list.add(entity5);
		
		repository.saveAll(list);
	}
	
	@Test
	public void 구장검색() {
		List<CourtEntity> list = repository.findAll();
		for(CourtEntity entity : list) {
			System.out.println(entity);
		}
	}
}
