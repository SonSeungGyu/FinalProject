package com.example.demo.teamTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.team.dto.TeamDto;
import com.example.demo.team.service.TeamService;



@SpringBootTest
public class TeamServiceTest {
	@Autowired
	 TeamService service;
	@Test
	public void 팀등록() {
		TeamDto dto = TeamDto.builder().teamName("백호").teamAddress("계산동").teamMember("user1").teamMember2("user2")
				.teamMember3("user3").teamMember4("user4").teamMember5("user5").teamMember6("user6").build();
		service.register(dto);
	}
	@Test
	public void 팀상세조회() {
		TeamDto dto = service.read(1);
		System.out.println(dto);
	}
}
