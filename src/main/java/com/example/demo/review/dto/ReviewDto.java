package com.example.demo.review.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString 
@Builder 
public class ReviewDto {

	int programNo ; // 프로그램 넘버   (ProgramEntity와 연동)
	
	String reviewWriter; // 작성자	(MemberEntity와 연동)
	
	
	
	String memberId; // 멤버아이디
		
	int reviewNo; // 리뷰넘버번호 .시스템이 자동처리
		
	String reviewTitle;	// 리뷰 제목
	
	String reviewContent ; // 내용	
	
//	(변수타입) review_img // 리뷰 사진 첨부	
	
	LocalDateTime regDate;	// 최초작성
	
	LocalDateTime modDate; // 수정날짜
	
}
