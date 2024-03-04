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

	
	



}
