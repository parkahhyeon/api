/*
package com.hakg.core.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;    // 사용자 정보

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordUtEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/login").permitAll() // 로그인 페이지는 인증 없이 접근 가능하도록 설정
                    .antMatchers("/signup").permitAll() // 회원가입 페이지는 인증 없이 접근 가능하도록 설정
                    .antMatchers("/css/**").permitAll()
                    .anyRequest().authenticated() // 다른 요청은 인증이 필요하도록 설정
                .and()
                    .formLogin() // Form 로그인 인증 기능이 작동함
                        .loginPage("/login") // 로그인 페이지 경로 설정
                        .defaultSuccessUrl("/board")//로그인 성공 후 이동 페이지
                        .failureUrl("/account.html?error=true")// 로그인 실패 후 이동 페이지
                        .usernameParameter("username")//아이디 파라미터명 설정
                        .passwordParameter("password")//패스워드 파라미터명 설정
                        .loginProcessingUrl("/login")//로그인 Form Action Url
    //                    .successHandler(loginSuccessHandler())//로그인 성공 후 핸들러 (해당 핸들러를 생성하여 핸들링 해준다.)
    //                    .failureHandler(loginFailureHandler());//로그인 실패 후 핸들러 (해당 핸들러를 생성하여 핸들링 해준다.)
    //                    .permitAll(); //사용자 정의 로그인 페이지 접근 권한 승인
                .and()
                    .logout()
                        .logoutSuccessUrl("/login?logout") // 로그아웃 후 리디렉션될 경로 설정
                .and()
                    .build(); // CSRF 보안 설정 해제 (테스트 시 간단하게 사용하기 위함)
    }


}
*/
