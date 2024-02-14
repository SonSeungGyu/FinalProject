// 9장 p.14
package com.example.demo.review.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.program.entity.ProgramEntity;
import com.example.demo.review.dto.ReviewDto;
import com.example.demo.review.entity.ReviewEntity;
import com.example.demo.review.repository.ReviewRepository;

@Service//서비스 클래스로 지정하기. 컨테이너에 들어감. CommentService 호출시, CommentService상속받은 클래스 중에 CommentServiceImpl호출됨. 
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewRepository repository;

// 등록 - 외부에서 전달받은 ReviewDTO => entity로 변환시켜 저장하고 저장된 entity에서 댓글번호 반환 
	@Override
	public int register(ReviewDto dto) {
		ReviewEntity entity = dtoToEntity(dto);
		
		repository.save(entity);
		
		//저장되어 생성된 댓글 번호 반환
		return entity.getReviewNo();
	}

	
// 조회 - 프로그램번호에 해당하는 댓글 리스트들 db에서 꺼내서 반환하는 메서드
	@Override
	public List<ReviewDto> getListByProgramNo (int programNo) {
		
		// 프로그램객체 (특정 프로그램 번호[PK] 있는) 생성
		ProgramEntity program = ProgramEntity.builder()
						.programNo(programNo)
						.build();
		
		// 프로그램번호에 해당하는 게시물 DB에서 꺼내서 entity 리스트 생성
		List<ReviewEntity> entityList = repository.findByProgram(program);
												//ㄴ CommentRepository에 쿼리메서드로 정의
		List<ReviewDto> dtoList = new ArrayList<>();
		
		// 꺼낸 리뷰(댓글)entity 리스트 리뷰dto로 변경해서 reviewDTo리스트에 넣기
		for(ReviewEntity entity : entityList) {
			ReviewDto dto = entityToDTO(entity);
			
			dtoList.add(dto);
		}
		
		return dtoList;		
	}
	

	// 삭제 - 특정 번호의 댓글 삭제하기   9장 19페이지 연동해서 수정
	@Override
	public boolean remove(int reviewNo) {
	// 해당 댓글이 있는지 확인
	Optional<ReviewEntity> comment = repository.findById(reviewNo);
	
	// 없다면 false 반환
	if(comment.isEmpty()) { // isEmpty()는 Optional함수에 있는 메서드
		return false;
	}	
	
	// 있다면 댓글 삭제 후 true 반환   //여기에 if(comment.isPresent())넣고 위에거 없애도 된다.
	repository.deleteById(reviewNo);
	return true;
 }	

	
	
/*
 * // 삭제 - 특정 번호의 댓글 삭제하기 - 2월 2일에 위에 메서드 추가해서 없앰. service에 있는 remove 메서드는 void타입에서 boolean타입으로 변환
 * 
 * @Override public void remove(int no) {
 * 
 * repository.deleteById(no);
 * 
 *  }
 */
}
	

	 












