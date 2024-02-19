// 9장 p.13
package com.example.demo.comment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.comment.dto.CommentDto;
import com.example.demo.comment.entity.CommentEntity;
import com.example.demo.member.entitly.MemberEntity;
 
public interface CommentService {
	// 댓글 등록 메서드
	int register (CommentDto dto);
	
	// 프로그램을 기준으로 댓글 목록을 조회하는 메서드
	List<CommentDto> getListByBoardNo(int boardNo);
		
	// 댓글 삭제 메서드
		boolean remove(int no);
	
		
	// dto => Entity 반환
	default CommentEntity dtoToEntity (CommentDto dto ) {
		// ReviewDTO에서 작성자 꺼내서 작성자(MemberEntity) entity 만들기
		MemberEntity member = MemberEntity.builder()
				.memberId(dto.getCommentWriter())
				.build();
		// ReviewDTO에서 게시물번호 꺼내서 프로그램(ProgramEntity) entity 만들기		
		BoardEntity board = BoardEntity.builder()
				.boardNo(dto.getBoard())
				.build();
		
		
		// ReviewDto에서 값 꺼내서 댓글(Review) entity 생성
		CommentEntity entity = CommentEntity.builder()
				.commentNo(dto.getCommentNo())
				.commentWriter(member)
				.board(board)
				.commentContent(dto.getCommentContent())				
				.build();
				
		return entity;		
	}
	
	// Entity => dto 반환
	default CommentDto entityToDTO (CommentEntity entity) {
		CommentDto dto = CommentDto.builder()
				
					.commentNo(entity.getCommentNo())
				.board(entity.getBoard().getBoardNo()) 
// entity의 멤변 program(ProgramEntity 타입)의 멤변 programNo(int) => ReviewDTO의 멤변 programNo(int)에 넣어줌
					.commentContent(entity.getCommentContent())
				.commentWriter(entity.getCommentWriter().getMemberId())					 
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
