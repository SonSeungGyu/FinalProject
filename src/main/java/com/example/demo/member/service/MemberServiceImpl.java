package com.example.demo.member.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.entitly.MemberEntity;
import com.example.demo.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired

	MemberRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Page<MemberDto> getList(int pageNumber) {

		int pageIndex = (pageNumber == 0) ? 0 : pageNumber - 1;

		Sort sort = Sort.by("regDate").descending();

		Pageable pageable = PageRequest.of(pageIndex, 10, sort);

		Page<MemberEntity> entityPage = repository.findAll(pageable);

		Page<MemberDto> dtoPage = entityPage.map(entity -> entityToDto(entity));

		return dtoPage;
	}

	@Override
	public boolean register(MemberDto dto) {

		String id = dto.getMemberId();

		MemberDto getDto = read(id);

		if (getDto != null) {
			System.out.println("이미 사용중인 아이디여유 ~");
			return false;
		}
		MemberEntity entity = dtoToEntity(dto);

		String enPw = passwordEncoder.encode(entity.getMemberPassword());
		entity.setMemberPassword(enPw);

		repository.save(entity);
//		System.out.println("정상적으로 회원가입 했슈~"+repository.save(entity));
		return true;
	}

	@Override
	public MemberDto read(String id) {
		Optional<MemberEntity> result = repository.findById(id);
		if (result.isPresent()) {
			MemberEntity entity = result.get();
			return entityToDto(entity);
		} else {
			return null;
		}
	}


	//0222 사용자 정보 수정
	@Override
	public void modify(MemberDto dto) {
		//파라미터로 받은 dto는 DTO 타입이므로 프라이머리키인 no로 접근후
		//이 no는 레파지토리의 엔티티 no와 같음을 이용하여 엔티티 타입의 변수에 할당.
		Optional<MemberEntity> result = repository.findById(dto.getMemberId());
		
		if(result.isPresent()) {
			MemberEntity entity = result.get();
			
			//기존 엔티티에서 제목과 내용만 변경
			entity.setMemberAddress(dto.getMemberAddress());
			entity.setMemberEmail(dto.getMemberEmail());
			entity.setMemberNumber(dto.getMemberNumber());
			entity.setMemberBirthDay(dto.getMemberBirthDay());
			
			//다시 저장
			repository.save(entity);
		}
	}

	@Override
	public MemberDto saveSocialMember(String email) {
		
		//  기존 동일한 이메일로 가입이 있는지 확인
		Optional<MemberEntity> result =repository.findById(email);
		// 가입된 이메일이 있으면 반환
		if(result.isPresent()) {
			return entityToDto(result.get());
		}
		// 가입된 이메일이 없으면 회원가입 진행
		MemberEntity memberEntity = MemberEntity.builder()
				.memberId(email) // 모든 내용을 이메일로 처리
				.memberName(email)
				.memberPassword(passwordEncoder.encode("1111")) // 비밀번호 1111으로 일단 처리
				.memberAddress(email)
				.memberBirthDay(email)
				.memberNumber("333")
				.memberEmail(email)
				.role("ROLE_USER")
				.fromSocial(true)
				.build();
		repository.save(memberEntity);
		
		result = repository.findById(email);
		
		return entityToDto(result.get()); // 새로운 회원정보 or 기존 회원정보 반환
	}

	
	



}
