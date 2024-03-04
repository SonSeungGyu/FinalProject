package com.example.demo.etc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTest {

	@Autowired
	PasswordEncoder encoder;
	
	@Test
	public void 암호화테스트() {
		//비밀번호 암호화 설정
		String password = "1234";
		// 위 문자열을 encode를 사용해 암호화 시킴(해시코드 바꿈 ?) : 로그인창에서 패스워드를 암호하 시킬때 사용
		String enPw = encoder.encode(password);
		
		System.out.println("enPw" + enPw);
		// matches를 사용해 비밀번호가 1234가 맞는지 확인(문자열과 해시코드 비교) : 로그인할때 비밀번호가 일치한지 사용
		boolean matchResult = encoder.matches(password, enPw);
		
		System.out.println("확인결과" + matchResult);
	}
}
