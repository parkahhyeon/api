package com.hakg.api.service;

import com.hakg.api.domain.User;
import com.hakg.api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor    // 밑의 UserMapper의 생성자를 쓰지 않기 위해서
public class AccountService {

    //    private final BoardMapper boardMapper;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordUtEncoder;

    /*public AccountService(UserMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }*/

    public String signUp(User user) {
        user.setPwd(passwordUtEncoder.encode(user.getPwd()));
        userMapper.signUp(user);

        return user.getUserId();
    }

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
}
