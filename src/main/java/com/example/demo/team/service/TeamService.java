package com.example.demo.team.service;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.team.dto.TeamDto;
import com.example.demo.team.entity.TeamEntity;

public interface TeamService {
	int register(TeamDto dto);
	
	TeamDto read(int no);
	
	default TeamEntity dtoToEntity(TeamDto teamDto) {
		MemberEntity member1 = MemberEntity.builder().memberId(teamDto.getTeamMember()).build();
		MemberEntity member2 = MemberEntity.builder().memberId(teamDto.getTeamMember2()).build();
		MemberEntity member3 = MemberEntity.builder().memberId(teamDto.getTeamMember3()).build();
		MemberEntity member4 = MemberEntity.builder().memberId(teamDto.getTeamMember4()).build();
		MemberEntity member5 = MemberEntity.builder().memberId(teamDto.getTeamMember5()).build();
		MemberEntity member6 = MemberEntity.builder().memberId(teamDto.getTeamMember6()).build();
		TeamEntity teamEntity = TeamEntity.builder().teamAddress(teamDto.getTeamAddress()).teamWin(teamDto.getTeamWin()).teamLose(teamDto.getTeamLose())
				.teamPoint(teamDto.getTeamPoint()).teamName(teamDto.getTeamName()).teamMember(member1).teamMember2(member2).teamMember3(member3)
				.teamMember4(member4).teamMember5(member5).teamMember6(member6).build();
		return teamEntity;
	}
	default TeamDto entityToDto(TeamEntity teamEntity) {
		TeamDto teamDto = TeamDto.builder().teamNo(teamEntity.getTeamNo()).teamName(teamEntity.getTeamName()).teamWin(teamEntity.getTeamWin())
				.teamLose(teamEntity.getTeamLose()).teamPoint(teamEntity.getTeamPoint()).teamAddress(teamEntity.getTeamAddress()).regDate(teamEntity.getRegDate())
				.modDate(teamEntity.getModDate()).teamMember(teamEntity.getTeamMember().getMemberId()).teamMember2(teamEntity.getTeamMember2().getMemberId())
				.teamMember3(teamEntity.getTeamMember3().getMemberId()).teamMember4(teamEntity.getTeamMember4().getMemberId()).teamMember5(teamEntity.getTeamMember5().getMemberId())
				.teamMember6(teamEntity.getTeamMember6().getMemberId()).build();
		return teamDto;
	}
}
