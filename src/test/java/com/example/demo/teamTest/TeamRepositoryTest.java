package com.example.demo.teamTest;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.team.entity.TeamEntity;
import com.example.demo.team.repository.TeamRepository;

@SpringBootTest
public class TeamRepositoryTest {
	@Autowired
	TeamRepository repository;
	@Test
	public void 팀등록() {
		MemberEntity member1 = MemberEntity.builder().memberId("user1").build();
		MemberEntity member2 = MemberEntity.builder().memberId("user2").build();
		MemberEntity member3 = MemberEntity.builder().memberId("user3").build();
		MemberEntity member4 = MemberEntity.builder().memberId("user4").build();
		MemberEntity member5 = MemberEntity.builder().memberId("user5").build();
		MemberEntity member6 = MemberEntity.builder().memberId("user6").build();
		TeamEntity teamEntity = TeamEntity.builder().teamName("백호").teamAddress("계산동").teamMember(member1).teamMember2(member2)
				.teamMember3(member3).teamMember4(member4).teamMember5(member5).teamMember6(member6).build();
		repository.save(teamEntity);
	}
	@Test
	public void 팀상세조회() {
		Optional<TeamEntity> optional = repository.findById(1);
		System.out.println(optional);
	}
}
