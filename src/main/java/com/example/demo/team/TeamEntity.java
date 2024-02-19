package com.example.demo.team;

import com.example.demo.allBaseEtity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(length = 100)
	String teamName;
//	@OneToMany
//	MemberEntity teamMember;
	@Column(length = 100, nullable = false)
	int win;
	@Column(length = 100, nullable = false)
	int lose;
	@Column(length = 100, nullable = false)
	int teamPoint;
	@Column(length = 100, nullable = false)
	String teamAddress;
	
	
	
	
	
	
}
