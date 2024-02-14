package com.example.demo.program.entity;

import com.example.demo.allBaseEtity.BaseEntity;
import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.notice.entity.NoticeEntity;

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

@Entity
@Table(name = "tbl_program")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class ProgramEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int programNo;
	
	@Column(length = 50, nullable = false)
	String programName;
	
	@Column(length = 100, nullable = false)
	String programContent;
	
	@Column(nullable = false)
	int programPrice;
	
	@Column(length = 100, nullable = false)
	MemberEntity memberId;
}
