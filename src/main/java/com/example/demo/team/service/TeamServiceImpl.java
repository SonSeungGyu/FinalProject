package com.example.demo.team.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.BoardEntity;
import com.example.demo.team.dto.TeamDto;
import com.example.demo.team.entity.TeamEntity;
import com.example.demo.team.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	TeamRepository repository;

	@Override
	public int register(TeamDto teamDto) {
		TeamEntity teamEntity = dtoToEntity(teamDto);
		repository.save(teamEntity);
		int newNo = teamEntity.getTeamNo();
		return newNo;
	}

	@Override
	public TeamDto read(int no) {
		Optional<TeamEntity> optional = repository.findById(no);
		if(optional.isPresent()) {
			TeamEntity teamEntity = optional.get();
			TeamDto teamDto = entityToDto(teamEntity);
			return teamDto;
		} else {
			return null;
		}
		
	}

}
