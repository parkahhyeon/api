package com.hakg.api.service;

import com.hakg.api.domain.User;
import com.hakg.api.mapper.BoardMapper;
import com.hakg.api.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

//    private final BoardMapper boardMapper;
    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordUtEncoder;

    /*public AccountService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }*/

    public boolean login(String username, String password) throws UsernameNotFoundException {
        // 사용자 조회
//        Member member = memberMapper.findByUsername(username);
//
//        if (member == null) {
//            throw new UsernameNotFoundException("Invalid username or password");
//            return false; // 사용자가 존재하지 않으면 로그인 실패
//        }
//
//        // 비밀번호 일치 여부 확인
//        if (!passwordEncoder.matches(password, member.getPassword())) {
//            return false; // 비밀번호가 일치하지 않으면 로그인 실패
//        }

        // 로그인 성공
        return true;
    }

    public String signUp(User user) {
        user.setPwd(passwordUtEncoder.encode(user.getPwd()));
        memberMapper.signUp(user);

        return user.getUserId();
    }
}
