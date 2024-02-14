// 9장 p.13
package com.example.demo.review.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.program.entity.ProgramEntity;
import com.example.demo.review.dto.ReviewDto;
import com.example.demo.review.entity.ReviewEntity;
 
public interface ReviewService {
	// 댓글 등록 메서드
	int register (ReviewDto dto);
	
	// 프로그램을 기준으로 댓글 목록을 조회하는 메서드
	List<ReviewDto> getListByProgramNo(int programNo);
		
	// 댓글 삭제 메서드
		boolean remove(int no);
	
		
	// dto => Entity 반환
	default ReviewEntity dtoToEntity (ReviewDto dto ) {
		// ReviewDTO에서 작성자 꺼내서 작성자(MemberEntity) entity 만들기
		MemberEntity member = MemberEntity.builder()
				.memberId(dto.getMemberId())
				.build();
		// ReviewDTO에서 게시물번호 꺼내서 프로그램(ProgramEntity) entity 만들기		
		ProgramEntity program = ProgramEntity.builder()
				.programNo(dto.getProgramNo())
				.build();
		
		
		// ReviewDto에서 값 꺼내서 댓글(Review) entity 생성
		ReviewEntity entity = ReviewEntity.builder()
				.reviewNo(dto.getReviewNo())
				.reviewWriter(member)
				.program(program)
				.reviewContent(dto.getReviewContent())				
				.build();
				
		return entity;		
	}
	
	// Entity => dto 반환
	default ReviewDto entityToDTO (ReviewEntity entity) {
		ReviewDto dto = ReviewDto.builder()
				
					.reviewNo(entity.getReviewNo())
				.programNo(entity.getProgram().getProgramNo()) 
// entity의 멤변 program(ProgramEntity 타입)의 멤변 programNo(int) => ReviewDTO의 멤변 programNo(int)에 넣어줌
					.reviewContent(entity.getReviewContent())
				.reviewWriter(entity.getReviewWriter().getMemberId())					 
// entity의 멤변 reviewWriter(MemberEntity 타입)의 멤변 memberId(string)=> ReviewDTO의 멤변 reviewWriter(String)에 넣어줌
					.regDate(entity.getRegDate())
					.modDate(entity.getModDate())
					
						.build();
		
		return dto;
	}
	
	
	
	
	
	
	
	/*
	 * 
	 * Page<CommentDTO> getList(int pageNumber); // ㄴ 회원 리스트+페이지 정보
	 * 
	 * // 엔티티를 DTO로 변환하는 메서드 (엔티티에서 dto추출해야 화면 view단에 넘겨줄 수 있으니까) default CommentDTO
	 * entityToDto(Comment entity) {
	 * 
	 * CommentDTO dto = CommentDTO.builder()
	 * .commentNo(entity.getCommentNo()).board(entity.getBoard().getNo())
	 * .content(entity.getContent()) .writer(entity.getWriter().getId())
	 * .regDate(entity.getRegDate()).modDate(entity.getModDate()) .build();
	 * 
	 * return dto; };
	 * 
	 * 
	 * // 2. 회원 단건 조회(상세조회) (8장 p.51) CommentDTO read(int commentNo);
	 * 
	 * 
	 * // 3. 회원 등록 (8장 p.42) boolean register(CommentDTO dto); // 회원등록시에 dto를 엔티티로
	 * 바꿔야 repository에 저장할 수 있지. ↓ // 회원등록 성공실패유무 알려주기 위해서 boolean으로 반환값 설정됨. //엔티티를
	 * DTO로 변환하는 메서드
	 * 
	 * 
	 * 
	 * default Member dtoToEntity (CommentDTO dto) { Comment comment =
	 * Comment.builder()
	 * .commentNo(dto.getCommentNo()).board(dto.getBoard()).writer(dto.getWriter())
	 * .build(); // cf) dto에서 입력받을때 regDate, modDate는 우리가 입력한 값이 아니므로 객체 생성시 넣지 않음.
	 * return comment; }
	 */
	
}
