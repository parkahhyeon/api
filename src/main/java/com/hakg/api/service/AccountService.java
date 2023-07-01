package com.hakg.api.service;

import com.hakg.api.domain.Member;
import com.hakg.api.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    /*public AccountService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }*/

    public boolean login(String username, String password) throws UsernameNotFoundException {
        // 사용자 조회
        Member member = memberMapper.findByUsername(username);

        if (member == null) {
            throw new UsernameNotFoundException("Invalid username or password");
            return false; // 사용자가 존재하지 않으면 로그인 실패
        }

        // 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(password, member.getPassword())) {
            return false; // 비밀번호가 일치하지 않으면 로그인 실패
        }

        // 로그인 성공
        return true;
    }

    @Transactional
    public String signUp(final Member params) {
        params.encodingPassword(passwordEncoder);
        memberMapper.signup(params);

        return params.getMem_id();
    }

}
