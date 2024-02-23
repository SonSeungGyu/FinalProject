package com.example.demo.board.entity;


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

@Entity
@Table(name = "tbl_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class BoardEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo;
	
	@ManyToOne
	MemberEntity boardWriter;
	
	@Column(length = 100, nullable = false)
	String boardTitle;
	
	@Column(length = 300, nullable = false)
	String boardContent;
	
	@Column(length = 200, nullable = true)
	String imgPath; // 첨부파일 이름
}
