package com.example.demo.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.entitly.MemberEntity;


public interface MemberRepository extends JpaRepository<MemberEntity,String>{

	Optional<MemberEntity> findByMemberId(String memberId);
}
