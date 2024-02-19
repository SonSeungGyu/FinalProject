package com.example.demo.comment.entity;

import com.example.demo.allBaseEtity.BaseEntity;
import com.example.demo.board.entity.BoardEntity;
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

@Table(name = "tbl_comment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentEntity extends BaseEntity {

	
	
	
	@Id // pk지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increament옵션
	int commentNo; //번호
	
	@ManyToOne
	BoardEntity board;
	
	@ManyToOne  
	MemberEntity commentWriter; //작성자 - 하나의 작성자(one) 여러개 댓글(many) 가질 수 있음.
	
	@Column(length=1500)
	String commentTitle;	// 리뷰 제목
	
	@Column(length=1500)
	String commentContent ; // 내용
	
	
	
	
}
