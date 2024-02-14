package com.example.demo.review.entity;

import com.example.demo.allBaseEtity.BaseEntity;
import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.program.entity.ProgramEntity;

//import com.example.demo.entity.Board;  
//import com.example.demo.entity.Comment;
//import com.example.demo.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReviewEntity extends BaseEntity {

	ProgramEntity program ; // 프로그램 넘버
	
	MemberEntity member ; // 멤버 아이디	
	
	
	@Id // pk지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increament옵션
	int reviewNo; //번호
	
//	@ManyToOne // 
//	Programentity program; //게시물 - 하나의 프로그램페이지(one) 여러개 댓글(many) 가질 수 있음. 
	@Column(length=1500)
	String reviewTitle;	// 리뷰 제목
	
	@Column(length=1500)
	String reviewContent ; // 내용
	
//	@ManyToOne
//	Member reviewWriter; //작성자 - 하나의 작성자(one) 여러개 댓글(many) 가질 수 있음.	
	
	
}
