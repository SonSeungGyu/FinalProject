package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// 0222 myPage 추가
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = User.builder();
//	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	// 0304 로그인페이지로 바로 가게 수정중입니다.
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.requestMatchers("/assets/*", "/css/*", "/js/*").permitAll()
				.requestMatchers("/memeber/register").permitAll()
				.requestMatchers("/").permitAll()
				//회원 및 관리자 회원권한
				.requestMatchers("/member/mypage").hasAnyRole("ADMIN","USER")
				.requestMatchers("/member/modify").hasAnyRole("ADMIN","USER")
				.requestMatchers("/member/list").hasRole("ADMIN")
				// 게시판 사용권한
				.requestMatchers("/board/*").hasAnyRole("ADMIN","USER")
				// 댓글 사용권한
				.requestMatchers("/comment/*").hasAnyRole("ADMIN","USER")
				.anyRequest().permitAll(); //메인페이지로 바로 가게끔

		http.formLogin().defaultSuccessUrl("/",true);
		http.csrf().disable();
		http.logout();



		http.oauth2Login().loginProcessingUrl("customlogin")
		.successHandler(new CustomAuthenticationSuccessHandler());
		return http.build();

		

	}
}
