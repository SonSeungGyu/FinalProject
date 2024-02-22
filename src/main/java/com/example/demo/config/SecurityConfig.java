package com.example.demo.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//0222 myPage 추가
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = User.builder();
//	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()

				.requestMatchers("/register").permitAll()
				.requestMatchers("/assets/*", "/css/*", "/js/*").permitAll()

				.requestMatchers("/").permitAll()
			
				.anyRequest().permitAll();

		http.formLogin()
				// 로그인 화면 주소
				.loginPage("/customlogin")
				// 로그인 처리 주소
				.loginProcessingUrl("/login")
				// 모든 사용자 사용 가능(접근 권한)
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						response.sendRedirect("/");
					}

				}).permitAll();

		// security가 제공하는 기능 중 로그아웃 기능
		http.logout();

		// csrf 설정 해제
		http.csrf().disable();
		return http.build();

	}
}
