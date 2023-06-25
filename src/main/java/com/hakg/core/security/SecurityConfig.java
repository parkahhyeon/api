package com.hakg.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll() // 로그인 페이지는 인증 없이 접근 가능하도록 설정
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated() // 다른 요청은 인증이 필요하도록 설정
                .and()
                .formLogin()
                .loginPage("/login") // 로그인 페이지 경로 설정
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // 로그아웃 후 리디렉션될 경로 설정
                .and()
                .build(); // CSRF 보안 설정 해제 (테스트 시 간단하게 사용하기 위함)
    }
}