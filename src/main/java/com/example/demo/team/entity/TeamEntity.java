package com.example.demo.team.entity;

import com.example.demo.allBaseEtity.BaseEntity;
import com.example.demo.member.entitly.MemberEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_team")
public class TeamEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int teamNo;
	
	@Column(length = 100,nullable = false)
	String teamName;
	@ManyToOne
	MemberEntity teamMember;
	@ManyToOne
	MemberEntity teamMember2;
	@ManyToOne
	MemberEntity teamMember3;
	@ManyToOne
	MemberEntity teamMember4;
	@ManyToOne
	MemberEntity teamMember5;
	@ManyToOne
	MemberEntity teamMember6;
	@Column(length = 100, nullable = true)
	int teamWin;
	@Column(length = 100, nullable = true)
	int teamLose;
	@Column(length = 100, nullable = true)
	int teamPoint;
	@Column(length = 100, nullable = false)
	String teamAddress;
	
	
	
	
	
	
}
