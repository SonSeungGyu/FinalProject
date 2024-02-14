package com.example.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.entitly.MemberEntity;

public interface memberRepository extends JpaRepository<MemberEntity,String>{

}
